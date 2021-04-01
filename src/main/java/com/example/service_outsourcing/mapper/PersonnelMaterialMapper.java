package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.PersonnelMaterial;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonnelMaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(PersonnelMaterial record);

    PersonnelMaterial selectByPrimaryKey(String materialId);

    List<PersonnelMaterial> selectAll();

    int updateByPrimaryKey(PersonnelMaterial record);
}