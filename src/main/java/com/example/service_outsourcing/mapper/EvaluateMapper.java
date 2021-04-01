package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Evaluate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EvaluateMapper {
    int deleteByPrimaryKey(String evaluateId);

    int insert(Evaluate record);

    Evaluate selectByPrimaryKey(String evaluateId);

    List<Evaluate> selectAll();

    int updateByPrimaryKey(Evaluate record);
}