package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Skill;
import com.example.service_outsourcing.entity.SocialInfo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 20:13
 */
@Repository
public interface SocialInfoMapper {
    int deleteByPrimaryKey(String socialInfoId);

    int insert(SocialInfo record);

    SocialInfo selectByPrimaryKey(String socialInfoId);

    List<SocialInfo> selectByMaterialId(String materialId);

    List<SocialInfo> selectAll();

    int updateByPrimaryKey(Skill socialInfoId);
}
