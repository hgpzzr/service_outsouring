package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.EntryRegister;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EntryRegisterMapper {
    int deleteByPrimaryKey(String registerId);

    int insert(EntryRegister record);

    EntryRegister selectByPrimaryKey(String registerId);

    List<EntryRegister> selectByMaterialId(String materialId);

    List<EntryRegister> selectAll();

    int updateByPrimaryKey(EntryRegister record);
}