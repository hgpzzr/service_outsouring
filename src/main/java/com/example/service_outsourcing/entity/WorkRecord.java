package com.example.service_outsourcing.entity;

import lombok.Data;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 18:42
 */
@Data
public class WorkRecord {
	private String recordId;

	private String employeeId;

	private String organizationId;

	private String postId;

	private String beginTime;

	private String endTime;

	private Integer workStatus;

	private static final long serialVersionUID = 1L;
}
