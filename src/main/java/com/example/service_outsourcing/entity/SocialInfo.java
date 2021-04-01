package com.example.service_outsourcing.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 20:11
 */
@Data
public class SocialInfo implements Serializable {
    private String materialId;

    private String socialInfoId;

    private String infoName;

    private String concreteContent;

    private String supportingMaterialUrl;
}
