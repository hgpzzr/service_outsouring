package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Category;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.service.CategoryService;
import com.example.service_outsourcing.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 16:26
 */
@RestController
@Slf4j
@RequestMapping("/categories")
@CrossOrigin
@Api(tags = "岗位类型接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    @ApiOperation("添加新岗位类型")
    public ResultVO insertCategory(String postCategoryName){
        return categoryService.insertCategory(postCategoryName);
    }

    @GetMapping()
    @ApiOperation("查询所有岗位类型信息")
    public ResultVO categorylist(){
        return categoryService.categorylist();
    }

    @DeleteMapping()
    @ApiOperation("删除岗位类型")
    public ResultVO deleteCategory(String postCategoryId){
        return categoryService.deleteCategory(postCategoryId);
    }

    @PutMapping()
    @ApiOperation("修改岗位类型")
    public ResultVO updatecategory(Category category){
        return categoryService.updatecategory(category);
    }

}
