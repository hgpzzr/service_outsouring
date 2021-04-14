package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.ContractForm;
import com.example.service_outsourcing.form.IDForm;
import com.example.service_outsourcing.form.ProveFileForm;
import com.example.service_outsourcing.form.SocialInfoForm;
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
	public ResultVO insertPersonnelMaterial(String employeeId){
		return personnelMaterialsService.insertPersonnelMaterial(employeeId);
	}

	@PostMapping("/insertID")
	@ApiOperation("添加身份证")
	public ResultVO insertID(IDForm form,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertID(form,file);
	}

	@DeleteMapping("/deleteID")
	@ApiOperation("删除身份证")
	public ResultVO deleteID(String identifyCardId){
		return personnelMaterialsService.deleteID(identifyCardId);
	}

	@PostMapping("/insertEducationProve")
	@ApiOperation("添加学历证明")
	public ResultVO insertEducationProve(String materialId,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertEducationProve(materialId,file);
	}

	@DeleteMapping("/deleteEducationProve")
	@ApiOperation("删除学历证明")
	public ResultVO deleteEducationProve(String educationId){
		return personnelMaterialsService.deleteEducationProve(educationId);
	}

	@PostMapping("/insertSocialInfo")
	@ApiOperation("添加社会信息")
	public ResultVO insertSocialInfo(SocialInfoForm form,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertSocialInfo(form,file);
	}

	@DeleteMapping("/deleteSocialInfo")
	@ApiOperation("删除社会信息")
	public ResultVO deleteSocialInfo(String socialInfoId){
		return personnelMaterialsService.deleteSocialInfo(socialInfoId);
	}

	@PostMapping("/insertEntryRegister")
	@ApiOperation("添加入职登记")
	public ResultVO insertEntryRegister(String materialId,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertEntryRegister(materialId,file);
	}

	@DeleteMapping("/deleteEntryRegister")
	@ApiOperation("删除入职登记")
	public ResultVO deleteEntryRegister(String registerId){
		return personnelMaterialsService.deleteEntryRegister(registerId);
	}

	@PostMapping("/insertPhysicalExamination")
	@ApiOperation("添加入职体检")
	public ResultVO insertPhysicalExamination(String materialId,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertPhysicalExamination(materialId,file);
	}

	@DeleteMapping("/deletePhysicalExamination")
	@ApiOperation("删除入职体检")
	public ResultVO deletePhysicalExamination(String physicalExaminationId){
		return personnelMaterialsService.deletePhysicalExamination(physicalExaminationId);
	}

	@PostMapping("/insertQuitProve")
	@ApiOperation("添加离职证明")
	public ResultVO insertQuitProve(String materialId,@RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertQuitProve(materialId,file);
	}

	@DeleteMapping("/deleteQuitProve")
	@ApiOperation("删除离职证明")
	public ResultVO deleteQuitProve(String quitId){
		return personnelMaterialsService.deleteQuitProve(quitId);
	}

	@PostMapping("/insertProveFile")
	@ApiOperation("添加证明材料")
	public ResultVO insertProveFile(ProveFileForm form, @RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertProveFile(form,file);
	}

	@DeleteMapping("/deleteProveFile")
	@ApiOperation("删除证明材料")
	public ResultVO deleteProveFile(String proveId){
		return personnelMaterialsService.deleteProveFile(proveId);
	}

	@PostMapping("/insertContract")
	@ApiOperation("添加合同")
	public ResultVO insertContract(ContractForm form, @RequestParam("file") MultipartFile file){
		return personnelMaterialsService.insertContract(form,file);
	}

	@DeleteMapping("/deleteContract")
	@ApiOperation("删除合同")
	public ResultVO deleteContract(String contractId){
		return personnelMaterialsService.deleteContract(contractId);
	}

	@GetMapping("/browse")
	@ApiOperation("浏览单个人事材料")
	public ResultVO browsePersonnelMaterial(String materialId){
		return personnelMaterialsService.browsePersonnelMaterial(materialId);
	}

	@DeleteMapping("/delete")
	@ApiOperation("删除单个人事材料")
	public ResultVO deletePersonnelMaterial(String materialId){
		return personnelMaterialsService.deletePersonnelMaterial(materialId);
	}
}
