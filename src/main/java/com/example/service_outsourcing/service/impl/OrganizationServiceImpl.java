package com.example.service_outsourcing.service.impl;


import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Organization;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.UpdateOrganizationForm;
import com.example.service_outsourcing.mapper.OrganizationMapper;
import com.example.service_outsourcing.service.OrganizationService;
import com.example.service_outsourcing.utils.FileUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

	@Autowired
	private OrganizationMapper organizationMapper;

	@Value("${img.enterpriseCertification.url}")
	private String enterpriseCertificationUrl;

	@Override
	public ResultVO updateOrganization(UpdateOrganizationForm updateOrganizationForm, MultipartFile file) {
		Organization organization = organizationMapper.selectByPrimaryKey(updateOrganizationForm.getOrganizationId());
		if (organization == null) {
			logger.error("【组织修改】 : 组织不存在");
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_NOT_EXISTS);
		}
		Boolean isHave = organizationMapper.checkExist(updateOrganizationForm.getOrganizationName());
		if (isHave) {
			logger.error("【组织修改】 : 组织名已经存在");
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_HAS_EXISTS);
		}
		FileUtil.deleteFile(organization.getAuthenticationPicUrl());
		String filePath = enterpriseCertificationUrl;
		StringBuilder stringBuilder = new StringBuilder();
		String fileName = FileUtil.generateFileName(file);
		stringBuilder.append(filePath).append(fileName);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			logger.error("【组织修改】 : 文件上传失败，修改失败");
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		BeanUtils.copyProperties(organization, updateOrganizationForm);
		organization.setAuthenticationPicUrl(stringBuilder.toString());
		if (organizationMapper.updateByPrimaryKey(organization) != 1) {
			logger.error("【组织修改】 : 修改数据库失败");
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_UPDATE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO getOrganizationById(String organizationId) {
		Organization organization = organizationMapper.selectByPrimaryKey(organizationId);
		if (organization == null) {
			logger.error("【组织修改】 : 查找失败，organizationId错误");
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_SELECT_ERROR);
		}
		return ResultVOUtil.success(organization);
	}

	@Override
	public ResultVO organizationList() {
		List<Organization> organizations = organizationMapper.selectAll();
		if (organizations == null) {
			logger.error("【组织修改】 : 查找失败");
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_SELECT_ERROR);
		}
		return ResultVOUtil.success(organizations);
	}
}
