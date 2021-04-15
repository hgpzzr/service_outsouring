package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Category;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertPostForm;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName PostService
 * @Description TODO
 * @Author Jack
 * @Date 2021/4/12 19:35
 * @Version 1.0
 */
@Service
public interface CategoryService {

	/**
	 *  添加新岗位类别（标签）
	 * @param postCategoryName
	 * @return
	 */
	ResultVO insertCategory(String postCategoryName);

	/**
	 *  删除类别
	 * @param postCategoryId
	 * @return
	 */
	ResultVO deleteCategory(String postCategoryId);

	/**
	 *  获取所有类别
	 * @return
	 */
	ResultVO categorylist();

	/**
	 *  修改类别
	 * @param category
	 * @return
	 */
	ResultVO updatecategory(Category category);



}
