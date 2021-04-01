package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(String postCategoryId);

    int insert(Category record);

    Category selectByPrimaryKey(String postCategoryId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}