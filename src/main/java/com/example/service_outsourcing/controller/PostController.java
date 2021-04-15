package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.*;
import com.example.service_outsourcing.service.ApplicantService;
import com.example.service_outsourcing.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 16:26
 */
@RestController
@Slf4j
@RequestMapping("/posts")
@CrossOrigin
@Api(tags = "岗位接口")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping()
    @ApiOperation("添加新岗位")
    public ResultVO insertPost(InsertPostForm insertPostForm){
        return postService.insertPost(insertPostForm);
    }

    @GetMapping("/post_id/{postId}")
    @ApiOperation("以岗位id查询岗位信息")
    public ResultVO getPostByPostId(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @GetMapping("/post_name/{postName}")
    @ApiOperation("以岗位名称查询岗位信息")
    public ResultVO getPostByPostName(@PathVariable String postName){
        return postService.getPostByName(postName);
    }

    @GetMapping("/department_id/{departmentId}")
    @ApiOperation("以部门id查询岗位信息")
    public ResultVO getPostByDepartmentId(@PathVariable String departmentId){
        return postService.getPostByDepartmentId(departmentId);
    }

    @GetMapping()
    @ApiOperation("查询所有岗位信息")
    public ResultVO postList(){
        return postService.postList();
    }

    @DeleteMapping()
    @ApiOperation("删除岗位")
    public ResultVO deletePost(String postId){
        return postService.deletePost(postId);
    }

    @PutMapping()
    @ApiOperation("修改岗位信息")
    public ResultVO updatePost(Post post){
        return postService.updatePost(post);
    }

}
