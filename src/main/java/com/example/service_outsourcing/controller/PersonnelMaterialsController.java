package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.*;
import com.example.service_outsourcing.service.PersonnelMaterialsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/11 20:36
 */
@RestController
@CrossOrigin
@RequestMapping("/personnelMaterials")
@Api(tags = "人事材料接口")
public class PersonnelMaterialsController {
	@Autowired
	private PersonnelMaterialsService personnelMaterialsService;

	@PostMapping("/insert")
	@ApiOperation("添加人事材料")
	public ResultVO insertPersonnelMaterial(String employeeId) {
		return personnelMaterialsService.insertPersonnelMaterial(employeeId);
	}

	@PostMapping("/insertID")
	@ApiOperation("添加身份证")
	public ResultVO insertID(IDForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertID(form, file);
	}

	@DeleteMapping("/deleteID")
	@ApiOperation("删除身份证")
	public ResultVO deleteID(String identifyCardId) {
		return personnelMaterialsService.deleteID(identifyCardId);
	}

	@PutMapping("/updateID")
	@ApiOperation("更新身份证")
	public ResultVO updateID(UpdateIDForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.updateID(form, file);
	}

	@GetMapping("/getID")
	@ApiOperation("获得一张身份证")
	public ResultVO getId(String identifyCardId) {
		return personnelMaterialsService.getID(identifyCardId);
	}

	@GetMapping("/getAllID")
	@ApiOperation("获得一份人事材料下的所有身份证")
	public ResultVO getAllID(String materialId) {
		return personnelMaterialsService.getAllID(materialId);
	}

	@PostMapping("/insertEducationProve")
	@ApiOperation("添加学历证明")
	public ResultVO insertEducationProve(String materialId, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertEducationProve(materialId, file);
	}

	@DeleteMapping("/deleteEducationProve")
	@ApiOperation("删除学历证明")
	public ResultVO deleteEducationProve(String educationId) {
		return personnelMaterialsService.deleteEducationProve(educationId);
	}

	@GetMapping("/getEducationProve")
	@ApiOperation("获得单个学历证明")
	public ResultVO getEducationProve(String educationId) {
		return personnelMaterialsService.getEducationProve(educationId);
	}

	@GetMapping("/getAllEducationProve")
	@ApiOperation("获得一份人事材料下的所有学历证明")
	public ResultVO getAllEducationProve(String materialId) {
		return personnelMaterialsService.getAllEducationProve(materialId);
	}

	@PostMapping("/insertSocialInfo")
	@ApiOperation("添加社会信息")
	public ResultVO insertSocialInfo(SocialInfoForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertSocialInfo(form, file);
	}

	@DeleteMapping("/deleteSocialInfo")
	@ApiOperation("删除社会信息")
	public ResultVO deleteSocialInfo(String socialInfoId) {
		return personnelMaterialsService.deleteSocialInfo(socialInfoId);
	}

	@PutMapping("/updateSocialInfo")
	@ApiOperation("更新社会信息")
	public ResultVO updateSocialInfo(UpdateSocialInfoForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.updateSocialInfo(form, file);
	}

	@GetMapping("/getSocialInfo")
	@ApiOperation("获得单个社会信息")
	public ResultVO getSocialInfo(String socialInfoId) {
		return personnelMaterialsService.getSocialInfo(socialInfoId);
	}

	@GetMapping("/getAllSocialInfo")
	@ApiOperation("获得一份人事材料下的所有社会信息")
	public ResultVO getAllSocialInfo(String materialId) {
		return personnelMaterialsService.getAllSocialInfo(materialId);
	}

	@PostMapping("/insertEntryRegister")
	@ApiOperation("添加入职登记")
	public ResultVO insertEntryRegister(String materialId, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertEntryRegister(materialId, file);
	}

	@DeleteMapping("/deleteEntryRegister")
	@ApiOperation("删除入职登记")
	public ResultVO deleteEntryRegister(String registerId) {
		return personnelMaterialsService.deleteEntryRegister(registerId);
	}

	@GetMapping("/getEntryRegister")
	@ApiOperation("获得单个入职登记")
	public ResultVO getEntryRegister(String registerId) {
		return personnelMaterialsService.getEntryRegister(registerId);
	}

	@GetMapping("/getAllEntryRegister")
	@ApiOperation("获得一份人事材料下的所有入职登记")
	public ResultVO getAllEntryRegister(String materialId) {
		return personnelMaterialsService.getAllEntryRegister(materialId);
	}

	@PostMapping("/insertPhysicalExamination")
	@ApiOperation("添加入职体检")
	public ResultVO insertPhysicalExamination(String materialId, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertPhysicalExamination(materialId, file);
	}

	@DeleteMapping("/deletePhysicalExamination")
	@ApiOperation("删除入职体检")
	public ResultVO deletePhysicalExamination(String physicalExaminationId) {
		return personnelMaterialsService.deletePhysicalExamination(physicalExaminationId);
	}

	@GetMapping("/getPhysicalExamination")
	@ApiOperation("获得单个入职体检")
	public ResultVO getPhysicalExamination(String physicalExaminationId) {
		return personnelMaterialsService.getPhysicalExamination(physicalExaminationId);
	}

	@GetMapping("/getAllPhysicalExamination")
	@ApiOperation("获得一份人事材料下的所有入职体检")
	public ResultVO getAllPhysicalExamination(String materialId) {
		return personnelMaterialsService.getAllPhysicalExamination(materialId);
	}

	@PostMapping("/insertQuitProve")
	@ApiOperation("添加离职证明")
	public ResultVO insertQuitProve(String materialId, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertQuitProve(materialId, file);
	}

	@DeleteMapping("/deleteQuitProve")
	@ApiOperation("删除离职证明")
	public ResultVO deleteQuitProve(String quitId) {
		return personnelMaterialsService.deleteQuitProve(quitId);
	}

	@GetMapping("/getQuitProve")
	@ApiOperation("获得单个离职证明")
	public ResultVO getQuitProve(String quitId) {
		return personnelMaterialsService.getQuitProve(quitId);
	}

	@GetMapping("/getAllQuitProve")
	@ApiOperation("获得一份人事材料下的所有离职证明")
	public ResultVO getAllQuitProve(String materialId) {
		return personnelMaterialsService.getAllQuitProve(materialId);
	}

	@PostMapping("/insertProveFile")
	@ApiOperation("添加证明材料")
	public ResultVO insertProveFile(ProveFileForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertProveFile(form, file);
	}

	@DeleteMapping("/deleteProveFile")
	@ApiOperation("删除证明材料")
	public ResultVO deleteProveFile(String proveId) {
		return personnelMaterialsService.deleteProveFile(proveId);
	}

	@PutMapping("/updateProveFile")
	@ApiOperation("更新证明材料")
	public ResultVO updateProveFile(UpdateProveFileForm form, @RequestParam("file") MultipartFile file){
		return personnelMaterialsService.updateProveFile(form,file);
	}

	@GetMapping("/getProveFile")
	@ApiOperation("获得单个证明材料")
	public ResultVO getProveFile(String proveId) {
		return personnelMaterialsService.getProveFile(proveId);
	}

	@GetMapping("/getAllProveFile")
	@ApiOperation("获得一份人事材料下的所有证明材料")
	public ResultVO getAllProveFile(String materialId) {
		return personnelMaterialsService.getAllProveFile(materialId);
	}

	@PostMapping("/insertContract")
	@ApiOperation("添加合同")
	public ResultVO insertContract(ContractForm form, @RequestParam("file") MultipartFile file) {
		return personnelMaterialsService.insertContract(form, file);
	}

	@DeleteMapping("/deleteContract")
	@ApiOperation("删除合同")
	public ResultVO deleteContract(String contractId) {
		return personnelMaterialsService.deleteContract(contractId);
	}

	@PutMapping("/updateContract")
	@ApiOperation("更新合同")
	public ResultVO updateContract(UpdateContractForm form, @RequestParam("file") MultipartFile file){
		return personnelMaterialsService.updateContract(form,file);
	}

	@GetMapping("/getContract")
	@ApiOperation("获得单个合同")
	public ResultVO getContract(String contractId) {
		return personnelMaterialsService.getContract(contractId);
	}

	@GetMapping("/getAllContract")
	@ApiOperation("获得一份人事材料下的所有合同")
	public ResultVO getAllContract(String materialId) {
		return personnelMaterialsService.getAllContract(materialId);
	}

	@GetMapping("/browse")
	@ApiOperation("浏览单个人事材料")
	public ResultVO browsePersonnelMaterial(String materialId) {
		return personnelMaterialsService.browsePersonnelMaterial(materialId);
	}

	@DeleteMapping("/delete")
	@ApiOperation("删除单个人事材料")
	public ResultVO deletePersonnelMaterial(String materialId) {
		return personnelMaterialsService.deletePersonnelMaterial(materialId);
	}

	@GetMapping("/all")
	@ApiOperation("获得所有人事材料")
	public ResultVO getAllPersonnelMaterial() {
		return personnelMaterialsService.getAllPersonnelMaterial();
	}
}
