package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.AchievementForm;
import com.example.service_outsourcing.form.AttendanceForm;
import com.example.service_outsourcing.form.EvaluateForm;
import com.example.service_outsourcing.form.WorkRecordForm;
import com.example.service_outsourcing.service.WorkRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/14 13:24
 */
@RestController
@CrossOrigin
@RequestMapping("/workRecord")
@Slf4j
@Api(tags = "工作记录接口")
public class WorkRecordController {
	@Autowired
	private WorkRecordService workRecordService;

	@ApiOperation("添加工作记录")
	@PostMapping("/insert")
	public ResultVO insertWorkRecord(WorkRecordForm form){
		return workRecordService.insertWorkRecord(form);
	}

	@ApiOperation("删除工作记录")
	@DeleteMapping("/delete")
	public ResultVO deleteWorkRecord(String recordId){
		return workRecordService.deleteWorkRecord(recordId);
	}

	@ApiOperation("添加绩效")
	@PostMapping("/insertAchievement")
	public ResultVO insertAchievement(AchievementForm form){
		return workRecordService.insertAchievement(form);
	}

	@ApiOperation("删除绩效")
	@DeleteMapping("/deleteAchievement")
	public ResultVO deleteAchievement(String achievementId){
		return workRecordService.deleteAchievement(achievementId);
	}

	@GetMapping("/getAchievement")
	@ApiOperation("获得单个绩效")
	public ResultVO getAchievement(String achievementId){
		return workRecordService.getAchievement(achievementId);
	}

	@GetMapping("/getAllAchievement")
	@ApiOperation("获得一份工作记录下的所有绩效")
	public ResultVO getAllAchievement(String recordId){
		return workRecordService.getAllAchievement(recordId);
	}

	@ApiOperation("添加评价")
	@PostMapping("/insertEvaluate")
	public ResultVO insertEvaluate(EvaluateForm form){
		return workRecordService.insertEvaluate(form);
	}

	@ApiOperation("删除评价")
	@DeleteMapping("/deleteEvaluate")
	public ResultVO deleteEvaluate(String evaluateId){
		return workRecordService.deleteEvaluate(evaluateId);
	}

	@GetMapping("/getEvaluate")
	@ApiOperation("获得单个评价")
	public ResultVO getEvaluate(String evaluateId){
		return workRecordService.getEvaluate(evaluateId);
	}

	@GetMapping("/getAllEvaluate")
	@ApiOperation("获得一份工作记录下的所有评价")
	public ResultVO getAllEvaluate(String recordId){
		return workRecordService.getAllAEvaluate(recordId);
	}

	@ApiOperation("添加考勤")
	@PostMapping("/insertAttendance")
	public ResultVO insertAttendance(AttendanceForm form){
		return workRecordService.insertAttendance(form);
	}

	@ApiOperation("删除考勤")
	@DeleteMapping("/deleteAttendance")
	public ResultVO deleteAttendance(String attendanceId){
		return workRecordService.deleteAttendance(attendanceId);
	}

	@GetMapping("/getAttendance")
	@ApiOperation("获得单个考勤记录")
	public ResultVO getAttendance(String attendanceId){
		return workRecordService.getAttendance(attendanceId);
	}

	@GetMapping("/getAllAttendance")
	@ApiOperation("获得一份工作记录下的所有考勤记录")
	public ResultVO getAllAttendance(String recordId){
		return workRecordService.getAllAttendance(recordId);
	}

	@ApiOperation("浏览单个工作记录")
	@GetMapping("/browseWorkRecord")
	public ResultVO browseWorkRecord(String recordId){
		return workRecordService.browseWorkRecord(recordId);
	}

	@ApiOperation("获得一个员工的所有工作记录")
	@GetMapping("/getAllWorkRecord")
	public ResultVO getAllWorkRecord(String employeeId){
		return workRecordService.getAllWorkRecord(employeeId);
	}
}
