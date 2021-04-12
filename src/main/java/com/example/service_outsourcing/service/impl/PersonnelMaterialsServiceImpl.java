package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.*;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.IDForm;
import com.example.service_outsourcing.form.SocialInfoForm;
import com.example.service_outsourcing.mapper.*;
import com.example.service_outsourcing.service.PersonnelMaterialsService;
import com.example.service_outsourcing.utils.FileUtil;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 12:59
 */
@Service
@Slf4j
public class PersonnelMaterialsServiceImpl implements PersonnelMaterialsService {
	@Autowired
	private PersonnelMaterialMapper personnelMaterialMapper;
	@Autowired
	private IdentifyCardMapper identifyCardMapper;
	@Autowired
	private EducationProveMapper educationProveMapper;
	@Autowired
	private SocialInfoMapper socialInfoMapper;
	@Autowired
	private EntryRegisterMapper entryRegisterMapper;
	@Autowired
	private EntryPhysicalExaminationMapper entryPhysicalExaminationMapper;
	@Autowired
	private QuitProveMapper quitProveMapper;
	@Autowired
	private ProveFileMapper proveFileMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private WorkRecordMapper workRecordMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Value("${img.ID.url}")
	private String imgIDUrl;
	@Value("${img.educationProve.url}")
	private String educationProveUrl;
	@Value("${img.socialInfo.url}")
	private String socialInfoUrl;
	@Value("${img.entryRegister.url}")
	private String registerUrl;

	@Override
	public ResultVO insertPersonnelMaterial(String employeeId) {
		if (employeeMapper.selectByPrimaryKey(employeeId) == null) {
			log.error("【添加人事材料】：员工不存在");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_NOT_EXIST_ERROR);
		}
		String materialId = GenerateIdUtil.getMaterialId(personnelMaterialMapper);
		PersonnelMaterial personnelMaterial = new PersonnelMaterial();
		personnelMaterial.setEmployeeId(materialId);
		personnelMaterial.setEmployeeId(employeeId);
		int insert = personnelMaterialMapper.insert(personnelMaterial);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO insertID(IDForm form, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(form.getMaterialId()) == null) {
			log.error("【添加身份证】：人事材料不存在");
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传文件
		// 获得url
		StringBuilder url = new StringBuilder();
		String filePath = imgIDUrl;
		// 生成随机文件名
		String fileName = FileUtil.generateFileName(file);
		url.append(filePath).append(fileName);
		// 上传
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			log.error("【添加身份证】：文件上传失败");
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		// 存入数据库
		IdentifyCard identifyCard = new IdentifyCard();
		BeanUtils.copyProperties(form, identifyCard);
		String identifyCardId = GenerateIdUtil.getIdentifyCardId(identifyCardMapper);
		identifyCard.setIdentityCardId(identifyCardId);
		identifyCard.setVerificationStatus(1);
		identifyCard.setIdentityCardPicUrl(url.toString());
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteID(String identifyCardId) {
		if (identifyCardMapper.selectByPrimaryKey(identifyCardId) == null) {
			log.error("【删除身份证】：身份证不存在");
			return ResultVOUtil.error(ResultEnum.ID_NOT_EXIST_ERROR);
		}
		int delete = identifyCardMapper.deleteByPrimaryKey(identifyCardId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertEducationProve(String materialId, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(materialId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传文件
		String filePath = educationProveUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);
		// 存入数据库
		EducationProve educationProve = new EducationProve();
		educationProve.setMaterialId(materialId);
		String educationId = GenerateIdUtil.getEducationId(educationProveMapper);
		educationProve.setEducationId(educationId);
		educationProve.setEducationProveStatus(1);
		educationProve.setEducationPicUrl(url.toString());
		int insert = educationProveMapper.insert(educationProve);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteEducationProve(String educationId) {
		if (educationProveMapper.selectByPrimaryKey(educationId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		int delete = educationProveMapper.deleteByPrimaryKey(educationId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertSocialInfo(SocialInfoForm form, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(form.getMaterialId()) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传文件
		String filePath = socialInfoUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		//存入数据库
		SocialInfo socialInfo = new SocialInfo();
		BeanUtils.copyProperties(form,socialInfo);
		String socialInfoId = GenerateIdUtil.getSocialInfoId(socialInfoMapper);
		socialInfo.setSocialInfoId(socialInfoId);
		socialInfo.setSupportingMaterialUrl(url.toString());
		int insert = socialInfoMapper.insert(socialInfo);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteSocialInfo(String socialInfoId) {
		if(socialInfoMapper.selectByPrimaryKey(socialInfoId)==null){
			return ResultVOUtil.error(ResultEnum.SOCIAL_INFO_NOT_EXIST_ERROR);
		}
		int delete = socialInfoMapper.deleteByPrimaryKey(socialInfoId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertEntryRegister(String materialId, MultipartFile file) {
		if(personnelMaterialMapper.selectByPrimaryKey(materialId)==null){
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		//上传文件
		String filePath = registerUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if(!upload){
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		// 存入数据库
		EntryRegister entryRegister = new EntryRegister();
		entryRegister.setMaterialId(materialId);
		String registerId = GenerateIdUtil.getRegisterId(entryRegisterMapper);
		entryRegister.setRegisterId(registerId);
		entryRegister.setRegisterPicUrl(url.toString());
		entryRegister.setRegisterPassStatus(1);
		int insert = entryRegisterMapper.insert(entryRegister);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteEntryRegister(String registerId) {
		if(entryRegisterMapper.selectByPrimaryKey(registerId)==null){
			return ResultVOUtil.error(ResultEnum.ENTRY_REGISTER_NOT_EXIST_ERROR);
		}
		int delete = entryRegisterMapper.deleteByPrimaryKey(registerId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

}