package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.form.UpdateOrganizationForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 类描述：
 *
 * @ClassName PostService
 * @Description TODO
 * @Author Jack
 * @Date 2021/4/12 19:35
 * @Version 1.0
 */
@Service
public interface OrganizationService {

	/**
	 * 修改组织
	 */
	ResultVO updateOrganization(UpdateOrganizationForm updateOrganizationForm, MultipartFile file);

	/**
	 * 获取组织信息By岗位ID
	 *
	 * @return
	 */
	ResultVO getOrganizationById(String organizationId);


	/**
	 * 获取所有组织信息
	 *
	 * @return
	 */
	ResultVO organizationList();

}
