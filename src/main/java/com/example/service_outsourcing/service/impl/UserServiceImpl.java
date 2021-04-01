package com.example.service_outsourcing.service.impl;


import com.example.service_outsourcing.VO.GetAllHRAccountVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Organization;
import com.example.service_outsourcing.entity.User;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.EnterpriseCertificationForm;
import com.example.service_outsourcing.form.LoginForm;
import com.example.service_outsourcing.form.RegisterForm;
import com.example.service_outsourcing.mapper.OrganizationMapper;
import com.example.service_outsourcing.mapper.UserMapper;
import com.example.service_outsourcing.security.JwtProperties;
import com.example.service_outsourcing.security.JwtUserDetailServiceImpl;
import com.example.service_outsourcing.service.UserService;
import com.example.service_outsourcing.utils.FileUtil;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.JwtTokenUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 20:01
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtProperties jwtProperties;

    @Value("${img.enterpriseCertification.url}")
    private String imageUrl;

    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.getUserByUserName(userName);
        return user;
    }

    @Transactional
    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String key = "anonymousUser";
        if (!userName.equals(key)) {
            return getUserByUserName(userName);
        }
        return null;
    }

    @Override
    public ResultVO register(RegisterForm registerForm) {
        boolean isHave = userMapper.getUserByUserName(registerForm.getUserName()) != null;
        if(isHave){
            return ResultVOUtil.error(ResultEnum.USER_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(registerForm,user);
        //设置权限为1
        user.setRole(1);
        user.setPasswd(passwordEncoder.encode(registerForm.getPasswd()));
        //生成随机的userId
        String userId = GenerateIdUtil.getUserId(userMapper);
        user.setUserId(userId);
        //设置会员级别
        user.setMembershipLevel(0);
        int insert = userMapper.insert(user);
        if(insert != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        Map map = new HashMap();
        map.put("message","注册成功");
        map.put("用户编号",userId);
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO login(LoginForm loginForm, HttpServletResponse response) {
        User user = userMapper.getUserByUserName(loginForm.getUserName());
        if (user == null) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        }
        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(loginForm.getUserName());
        if (!(new BCryptPasswordEncoder().matches(loginForm.getPasswd(), userDetails.getPassword()))) {
            return ResultVOUtil.error(ResultEnum.PASSWORD_ERROR);
        }
        Authentication token = new UsernamePasswordAuthenticationToken(loginForm.getUserName(), loginForm.getPasswd(), userDetails.getAuthorities());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String realToken = jwtTokenUtil.generateToken(userDetails);
        response.addHeader(jwtProperties.getTokenName(), realToken);
        Map<String, Serializable> map = new HashMap<>();
        map.put("name", user.getUserName());
        map.put("userId",user.getUserId());
        if(user.getRole() == 0){
            if(user.getIsHr() == 1){
                map.put("post","hr");
            }
            else {
                map.put("post","executive director");
                map.put("departmentId",user.getDepartmentId());
            }
            map.put("leader id",user.getLeaderId());
        }else {
            map.put("membership level",user.getMembershipLevel());
        }
        map.put("role", user.getRole());
        map.put("token", realToken);
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO addHR(LoginForm form) {
        //判断是否进行企业认证，若未认证，则无法添加hr账号
        User currentUser = getCurrentUser();
        if(currentUser.getOrganizationId() == null){
            return ResultVOUtil.error(ResultEnum.ENTERPRISES_WITHOUT_CERTIFICATION_ERROR);
        }
        //判断hr账号数量是否达到该用户的上限
        List<User> users = userMapper.selectByLeaderId(currentUser.getUserId());
        int size = users.size();
        switch (currentUser.getMembershipLevel()){
            case 0:
                if(size == 2){
                    return ResultVOUtil.error(ResultEnum.HR_NUM_ERROR);
                }
                break;
            case 1:
                if(size == 4){
                    return ResultVOUtil.error(ResultEnum.HR_NUM_ERROR);
                }
                break;
            case 2:
                if(size == 7){
                    return ResultVOUtil.error(ResultEnum.HR_NUM_ERROR);
                }
                break;
        }
        //设置用户信息
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPasswd(passwordEncoder.encode(form.getPasswd()));
        String userId = GenerateIdUtil.getUserId(userMapper);
        user.setUserId(userId);
        user.setOrganizationId(currentUser.getOrganizationId());
        user.setRole(0);
        user.setIsHr(1);
        user.setLeaderId(currentUser.getUserId());

        int insert = userMapper.insert(user);
        if(insert != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }

        Map<String,String> map = new HashMap<>();
        map.put("hrId",userId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO enterpriseCertification(EnterpriseCertificationForm form, MultipartFile file) {
        String filePath = imageUrl;
        //检查用户是否已经进行认证
        User currentUser = getCurrentUser();
        if(currentUser.getOrganizationId()!=null){
            return ResultVOUtil.error(ResultEnum.CERTIFICATE_REPEAT_ERROR);
        }
        String organizationId = GenerateIdUtil.getOrganizationId(organizationMapper);

        //获得图片路径
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = FileUtil.generateFileName(file);
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath,fileName);
        if(!upload){
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        //设置企业信息
        Organization organization = new Organization();
        organization.setAuthenticationPicUrl(stringBuilder.toString());
        organization.setAuthenticationStatus(1);
        organization.setOrganizationName(form.getOrganizationName());
        organization.setOrganizationId(organizationId);

        int insert = organizationMapper.insert(organization);
        if(insert!=1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }

        //更新用户信息
        currentUser.setOrganizationId(organizationId);
        int update = userMapper.updateByPrimaryKey(currentUser);
        if(update != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }

        return ResultVOUtil.success("认证成功");
    }

    @Override
    public ResultVO getAllHRAccount() {
        User currentUser = getCurrentUser();
        List<User> users = userMapper.selectByLeaderId(currentUser.getUserId());
        List<GetAllHRAccountVO> getAllHRAccountVOS = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            GetAllHRAccountVO getAllHRAccountVO = new GetAllHRAccountVO();
            BeanUtils.copyProperties(users.get(i),getAllHRAccountVO);
            getAllHRAccountVO.setHRId(users.get(i).getUserId());
            getAllHRAccountVOS.add(getAllHRAccountVO);
        }
        return ResultVOUtil.success(getAllHRAccountVOS);
    }

    @Override
    public ResultVO getAllHRAccount666666666666666() {
        return null;
    }
}
