package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    User selectByPrimaryKey(String userId);

    List<User> selectByLeaderId(String userId);

    User getUserByUserName(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}