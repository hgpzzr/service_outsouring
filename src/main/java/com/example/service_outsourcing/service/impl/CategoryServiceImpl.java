package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Category;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.mapper.CategoryMapper;
import com.example.service_outsourcing.mapper.EmployeeMapper;
import com.example.service_outsourcing.mapper.PostMapper;
import com.example.service_outsourcing.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private GenerateIdUtil generateIdUtil;

	@Override
	public ResultVO insertCategory(String postCategoryName) {
		Category category = new Category();
		category.setPostCategoryName(postCategoryName);
		String categoryId = generateIdUtil.getRandomId(categoryMapper, "CG");
		category.setPostCategoryId(categoryId);
		if (categoryMapper.insert(category) != 1) {
			logger.error("【岗位类型添加】: 岗位类型插入数据库失败");
			return ResultVOUtil.error(ResultEnum.CATEGORY_ADD_ERROR);
		}
		logger.info("【岗位类型添加】: 岗位类型添加成功=={}", category);
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO deleteCategory(String postCategoryId) {
		if(categoryMapper.deleteByPrimaryKey(postCategoryId)!=1){
			logger.error("【岗位类型删除】: 岗位类型删除失败");
			return ResultVOUtil.error(ResultEnum.CATEGORY_DELETE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO categorylist() {
		List<Category> categories = categoryMapper.selectAll();
		return ResultVOUtil.success(categories);
	}

	@Override
	public ResultVO updatecategory(Category category) {
		if(categoryMapper.updateByPrimaryKey(category)!=1){
			logger.error("【岗位类型修改】: 岗位类型修改失败");
			return ResultVOUtil.error(ResultEnum.CATEGORY_UPDATE_ERROR);
		}
		return ResultVOUtil.success();
	}
}
