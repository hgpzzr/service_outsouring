package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.IdentifyCard;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IdentifyCardMapper {
    int deleteByPrimaryKey(String identityCardId);

    int insert(IdentifyCard record);

    IdentifyCard selectByPrimaryKey(String identityCardId);

    List<IdentifyCard> selectAll();

    List<IdentifyCard> selectByMaterialId(String materialId);

    int updateByPrimaryKey(IdentifyCard record);
}