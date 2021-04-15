package com.example.service_outsourcing.VO;

import lombok.Data;

/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Data
public class PostVO {

	private String postId;

	private String departmentId;

	private String departmentName;

	private String psotName;

	private String postCategoryId;

	private Integer postMaxNum;

	private Integer postNowNum;

	private String postDescribe;

	private Integer postStatus;

}
