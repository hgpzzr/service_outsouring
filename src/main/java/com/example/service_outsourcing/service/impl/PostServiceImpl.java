package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.mapper.EmployeeMapper;
import com.example.service_outsourcing.mapper.PostMapper;
import com.example.service_outsourcing.service.PostCategoryService;
import com.example.service_outsourcing.service.PostService;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Service
public class PostServiceImpl implements PostService {

	private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private GenerateIdUtil generateIdUtil;

	@Autowired
	private PostCategoryService postCategoryService;

	@Override
	public ResultVO insertPost(InsertPostForm insertPostForm) {
		boolean isHave = postMapper.checkExistByPostName(insertPostForm.getPsotName());
		if (isHave) {
			logger.error("【岗位添加】: 岗位名称已经存在");
			return ResultVOUtil.error(ResultEnum.POST_NAME_ALREADY_EXISTS);
		}
		Post post = new Post();
		BeanUtils.copyProperties(insertPostForm, post);
		post.setPostStatus(1);
		String postId = generateIdUtil.getRandomId(postMapper, "PS");
		post.setPostId(postId);
		postCategoryService.insert(insertPostForm.getPostCategoryId(),postId);
		if (postMapper.insert(post) != 1) {
			logger.error("【岗位添加】: 岗位插入数据库失败");
			return ResultVOUtil.error(ResultEnum.POST_ADD_ERROR);
		}
		logger.info("【岗位添加】: 岗位添加成功=={}",post);
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO deletePost(String postId) {
		boolean isHave = postMapper.checkExistByPostId(postId);
		if (!isHave) {
			logger.error("【岗位删除】: 岗位不存在");
			return ResultVOUtil.error(ResultEnum.POST_NOT_EXISTS);
		}
		try {
			postMapper.deleteByPrimaryKey(postId);
			employeeMapper.updatePostByPostId(postId);
			PostVO postVO = postMapper.selectByPrimaryKey(postId);
			postCategoryService.delete(postVO.getPostCategoryId(),postId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("【岗位删除】: 岗位删除失败");
			return ResultVOUtil.error(ResultEnum.POST_DELETE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO updatePost(Post post) {
		PostVO postVO = postMapper.selectByPrimaryKey(post.getPostId());
		postCategoryService.delete(postVO.getPostCategoryId(),post.getPostId());
		postCategoryService.insert(post.getPostCategoryId(),post.getPostId());
		if(postMapper.updateByPrimaryKey(post)!=1){
			logger.error("【岗位修改】: 岗位修改失败");
			return ResultVOUtil.error(ResultEnum.POST_UPDATE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO getPostByName(String postName) {
		PostVO postVO = postMapper.selectByPostName(postName);
		if (postVO==null){
			logger.error("【岗位查询】: 岗位查询失败");
			return ResultVOUtil.error(ResultEnum.POST_SELECT_ERROR);
		}
		return ResultVOUtil.success(postVO);
	}

	@Override
	public ResultVO getPostById(String postId) {
		PostVO postVO = postMapper.selectByPrimaryKey(postId);
		if (postVO==null){
			logger.error("【岗位查询】: 岗位查询失败");
			return ResultVOUtil.error(ResultEnum.POST_SELECT_ERROR);
		}
		return ResultVOUtil.success(postVO);
	}

	@Override
	public ResultVO getPostByDepartmentId(String departmentId) {
		List<PostVO> postVOList = postMapper.selectByDepartmentId(departmentId);
		return ResultVOUtil.success(postVOList);
	}

	@Override
	public ResultVO postList() {
		List<PostVO> postVOList = postMapper.selectAll();
		return ResultVOUtil.success(postVOList);
	}
}
