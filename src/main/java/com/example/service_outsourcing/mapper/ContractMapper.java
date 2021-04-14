package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    Contract selectByPrimaryKey(String contractId);

    List<Contract> selectByMaterialId(String materialId);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);
}