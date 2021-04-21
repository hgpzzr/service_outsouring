package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.service.BatchService;
import com.example.service_outsourcing.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/19 20:32
 */
@RestController
@Slf4j
@RequestMapping("/batch")
@CrossOrigin
@Api(tags = "批量导入接口")
public class BatchController {
	@Autowired
	private BatchService batchService;

	@PostMapping("/uploadSkill")
	@ApiOperation("批量导入技能特长")
	public ResultVO batchUploadSkill(@RequestParam("file")MultipartFile file){
		try {
			return batchService.batchUploadSkill(file);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
	}
}
