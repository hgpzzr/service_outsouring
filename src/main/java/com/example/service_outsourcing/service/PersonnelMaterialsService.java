package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.EntryRegister;
import com.example.service_outsourcing.entity.WorkRecord;
import com.example.service_outsourcing.form.*;
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

	/**
	 * 添加入职登记
	 * @param materialId
	 * @param file
	 * @return
	 */
	ResultVO insertEntryRegister(String materialId,MultipartFile file);

	/**
	 * 删除入职登记
	 * @param registerId
	 * @return
	 */
	ResultVO deleteEntryRegister(String registerId);

	/**
	 * 添加入职体检
	 * @param materialId
	 * @param file
	 * @return
	 */
	ResultVO insertPhysicalExamination(String materialId,MultipartFile file);

	/**
	 * 删除入职体检
	 * @param examinationId
	 * @return
	 */
	ResultVO deletePhysicalExamination(String examinationId);

	/**
	 * 添加离职证明
	 * @param materialId
	 * @param file
	 * @return
	 */
	ResultVO insertQuitProve(String materialId,MultipartFile file);

	/**
	 * 删除离职证明
	 * @param quitId
	 * @return
	 */
	ResultVO deleteQuitProve(String quitId);

	/**
	 * 添加证明材料
	 * @param proveFileForm
	 * @param file
	 * @return
	 */
	ResultVO insertProveFile(ProveFileForm proveFileForm,MultipartFile file);

	/**
	 * 删除证明材料
	 * @param proveId
	 * @return
	 */
	ResultVO deleteProveFile(String proveId);

	/**
	 * 添加合同
	 * @param form
	 * @param file
	 * @return
	 */
	ResultVO insertContract(ContractForm form, MultipartFile file);

	/**
	 * 删除合同
	 * @param contractId
	 * @return
	 */
	ResultVO deleteContract(String contractId);

	/**
	 * 浏览单个人事材料
	 * @param materialId
	 * @return
	 */
	ResultVO browsePersonnelMaterial(String materialId);

	/**
	 * 删除人事材料
	 * @param materialId
	 * @return
	 */
	ResultVO deletePersonnelMaterial(String materialId);

	ResultVO getAllPersonnelMaterial();

}
