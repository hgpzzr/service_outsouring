package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.QuitProve;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuitProveMapper {
    int deleteByPrimaryKey(String quitId);

    int insert(QuitProve record);

    QuitProve selectByPrimaryKey(String quitId);

    List<QuitProve> selectAll();

    int updateByPrimaryKey(QuitProve record);
}