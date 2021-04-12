package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.EntryRegister;
import com.example.service_outsourcing.form.IDForm;
import com.example.service_outsourcing.form.SocialInfoForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 12:59
 */
@Service
public interface PersonnelMaterialsService {
	/**
	 * 添加人事材料
	 * @param employeeId
	 * @return
	 */
	ResultVO insertPersonnelMaterial(String employeeId);

	/**
	 * 添加身份证
	 * @param form
	 * @param file
	 * @return
	 */
	ResultVO insertID(IDForm form, MultipartFile file);

	/**
	 * 删除身份证
	 * @param identifyCardId
	 * @return
	 */
	ResultVO deleteID(String identifyCardId);

	/**
	 * 添加学历证明
	 * @param materialId
	 * @param file
	 * @return
	 */
	ResultVO insertEducationProve(String materialId,MultipartFile file);

	/**
	 * 删除学历证明
	 * @param educationId
	 * @return
	 */
	ResultVO deleteEducationProve(String educationId);

	/**
	 * 添加社会信息
	 * @param form
	 * @param file
	 * @return
	 */
	ResultVO insertSocialInfo(SocialInfoForm form,MultipartFile file);

	/**
	 * 删除社会信息
	 * @param socialInfoId
	 * @return
	 */
	ResultVO deleteSocialInfo(String socialInfoId);

	ResultVO insertEntryRegister(String materialId,MultipartFile file);

	ResultVO deleteEntryRegister(String registerId);
}
