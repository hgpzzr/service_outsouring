package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    PostVO selectByPrimaryKey(String postId);

    PostVO selectByPostName(String postName);

    Boolean checkExistByPostName(String postName);

    Boolean checkExistByPostId(String postId);

    List<PostVO> selectAll();

    List<PostVO> selectByDepartmentId(String departmentId);

    int updateByPrimaryKey(Post record);
}