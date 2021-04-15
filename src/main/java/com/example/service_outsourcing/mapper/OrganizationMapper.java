package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrganizationMapper {
    int deleteByPrimaryKey(String organizationId);

    int insert(Organization record);

    Organization selectByPrimaryKey(String organizationId);

    Boolean checkExist(String organizationName);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);
}