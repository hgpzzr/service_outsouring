package com.example.service_outsourcing.entity;

import lombok.Data;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/1 21:07
 */
@Data
public class IntegralUsageRecord {
    private String integralId;

    private String usageTime;

    private String usageRecord;

    private String userId;

    private static final long serialVersionUID = 1L;
}
