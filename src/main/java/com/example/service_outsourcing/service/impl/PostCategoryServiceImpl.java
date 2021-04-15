package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.entity.PostCategory;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.mapper.EmployeeMapper;
import com.example.service_outsourcing.mapper.PostCategoryMapper;
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
public class PostCategoryServiceImpl implements PostCategoryService {

	private static final Logger logger = LoggerFactory.getLogger(PostCategoryServiceImpl.class);

	@Autowired
	private PostCategoryMapper postCategoryMapper;

	@Override
	public ResultVO insert(String postCategoryId,String postId) {
		if(postCategoryMapper.insert(postCategoryId,postId)!=1){
			logger.error("【岗位类型关联添加】: 岗位类型关联添加失败");
			return ResultVOUtil.error(ResultEnum.CATEGORYLINK_ADD_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO delete(String postCategoryId, String postId) {
		if(postCategoryMapper.deleteByPrimaryKey(postCategoryId,postId)!=1){
			logger.error("【岗位类型关联删除】: 岗位类型关联删除失败");
			return ResultVOUtil.error(ResultEnum.CATEGORYLINK_DELETE_ERROR);
		}
		return ResultVOUtil.success();
	}
}
