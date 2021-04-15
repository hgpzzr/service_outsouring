package com.example.service_outsourcing.VO;

import lombok.Data;

/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Data
public class DepartmentVO {

	private String departmentId;

	private String departmentName;

	private Integer departmentEffectiveness;

	private String establishTime;

	private Integer maxNum;

	private Integer nowNum;

	private String leader;

	private String peopleInCharge;

	private String organizationId;

	private String organizationName;

}
