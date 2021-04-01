package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Achievement;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AchievementMapper {
    int deleteByPrimaryKey(String achievementId);

    int insert(Achievement record);

    Achievement selectByPrimaryKey(String achievementId);

    List<Achievement> selectAll();

    int updateByPrimaryKey(Achievement record);
}