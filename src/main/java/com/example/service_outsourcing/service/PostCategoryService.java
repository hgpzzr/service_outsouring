package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.entity.PostCategory;
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
public interface PostCategoryService {

	ResultVO insert(String postCategoryId,String postId);

	ResultVO delete(String postCategoryId,String postId);

}
