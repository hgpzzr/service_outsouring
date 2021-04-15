package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.PostCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryMapper {
    int deleteByPrimaryKey(@Param("postCategoryId") String postCategoryId, @Param("postId") String postId);

    int insert(@Param("postCategoryId") String postCategoryId, @Param("postId") String postId);

    List<PostCategory> selectAll();
}