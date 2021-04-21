package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.GrantAuthorization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrantAuthorizationMapper {
    int deleteByPrimaryKey(String grantAuthorizationId);

    int insert(GrantAuthorization record);

    GrantAuthorization selectByPrimaryKey(String grantAuthorizationId);

    List<GrantAuthorization> selectAll();

    int updateByPrimaryKey(GrantAuthorization record);
}