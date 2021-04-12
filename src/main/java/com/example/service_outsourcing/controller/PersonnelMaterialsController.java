package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.IDForm;
import com.example.service_outsourcing.form.SocialInfoForm;
import com.example.service_outsourcing.service.PersonnelMaterialsService;
import io.swagger.annotations.Api;
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
	public ResultVO insertPersonnelMaterial(String materialId){
		return personnelMaterialsService.insertPersonnelMaterial(materialId);
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
}
