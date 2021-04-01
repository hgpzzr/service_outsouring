package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.IdentifyCard;
import com.example.service_outsourcing.entity.IntegralUsageRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/1 21:08
 */
@Repository
public interface IntegralUsageRecordMapper {
    int deleteByPrimaryKey(String integralId);

    int insert(IntegralUsageRecord record);

    IntegralUsageRecord selectByPrimaryKey(String integralId);

    List<IntegralUsageRecord> selectAll();

    int updateByPrimaryKey(IntegralUsageRecord record);
}
