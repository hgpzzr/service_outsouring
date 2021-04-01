package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    Post selectByPrimaryKey(String postId);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);
}