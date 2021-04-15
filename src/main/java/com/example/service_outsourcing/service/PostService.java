package com.example.service_outsourcing.service;


import com.example.service_outsourcing.VO.ResultVO;
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
public interface PostService {

	/**
	 * @param insertPostForm 添加部门
	 */
	ResultVO insertPost(InsertPostForm insertPostForm);

	/**
	 * @param postId 删除部门Id
	 *               TODO   需要删除本岗位下面关联的员工
	 */
	ResultVO deletePost(String postId);

	/**
	 *	修改其他信息，包括修改岗位状态
	 * @param post 以员工的postId作为查询条件，
	 * @return
	 */
	ResultVO updatePost(Post post);

	/**
	 * 	获取岗位信息By岗位名称
	 * @param postName 岗位名称
	 * @return
	 */
	ResultVO getPostByName(String postName);

	/**
	 *  获取岗位信息By岗位ID
	 * @param postId  岗位ID
	 * @return
	 */
	ResultVO getPostById(String postId);

	ResultVO getPostByDepartmentId(String departmentId);

	/**
	 *  获取所有岗位信息
	 * @return
	 */
	ResultVO postList();

}
