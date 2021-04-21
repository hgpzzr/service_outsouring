package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.exception.MyException;
import com.example.service_outsourcing.form.EducationBackgroundForm;
import com.example.service_outsourcing.form.SkillForm;
import com.example.service_outsourcing.mapper.SkillMapper;
import com.example.service_outsourcing.service.ApplicantService;
import com.example.service_outsourcing.service.BatchService;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/19 20:20
 */
@Service
public class BatchServiceImpl implements BatchService {
	@Autowired
	private SkillMapper skillMapper;
	@Autowired
	private GenerateIdUtil generateIdUtil;
	@Autowired
	private ApplicantService applicantService;

	@Override
	public ResultVO batchUploadSkill(MultipartFile file){
		List<SkillForm> skillList = new ArrayList<>();
		// 判断文件版本
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		InputStream ins = null;
		Workbook wb = null;
		try {
			ins = file.getInputStream();
			if (suffix.equals("xlsx")) {
				wb = new XSSFWorkbook(ins);
			} else {
				wb = new HSSFWorkbook(ins);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取excel表单
		Sheet sheet = wb.getSheetAt(0);
		// line = 1 :从表的第2行开始获取记录
		if (null != sheet) {
			for (int line = 1; line <= sheet.getLastRowNum(); line++) {
				SkillForm skill = new SkillForm();
				Row row = sheet.getRow(line);
				if (null == row) {
					continue;
				}
				// 判断单元格类型是否为文本类型
				if (1 != row.getCell(0).getCellType()) {
					throw new MyException("单元格类型不是文本类型！");
				}
				row.getCell(0).setCellType(CellType.STRING);
				row.getCell(1).setCellType(CellType.STRING);
				row.getCell(2).setCellType(CellType.STRING);
				// 获取第一个单元格的内容
				String resumeId = row.getCell(0).getStringCellValue();
				// 获取第二个单元格的内容
				String skillName = row.getCell(1).getStringCellValue();
				String skillDescribe = row.getCell(2).getStringCellValue();
				skill.setResumeId(resumeId);
				skill.setSkillName(skillName);
				skill.setSkillDescribe(skillDescribe);
				skillList.add(skill);
			}
			for (SkillForm skill : skillList) {
				applicantService.insertSkill(skill);
			}
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO batchUploadEducationBackground(MultipartFile file) {
		List<EducationBackgroundForm> educationBackgroundFormList = new ArrayList<>();
		// 判断文件版本
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		InputStream ins = null;
		Workbook wb = null;
		try {
			ins = file.getInputStream();
			if (suffix.equals("xlsx")) {
				wb = new XSSFWorkbook(ins);
			} else {
				wb = new HSSFWorkbook(ins);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取excel表单
		Sheet sheet = wb.getSheetAt(0);
		// line = 1 :从表的第2行开始获取记录
		if (null != sheet) {
			for (int line = 1; line <= sheet.getLastRowNum(); line++) {
				EducationBackgroundForm form = new EducationBackgroundForm();
				Row row = sheet.getRow(line);
				if (null == row) {
					continue;
				}
				// 判断单元格类型是否为文本类型
				if (1 != row.getCell(0).getCellType()) {
					throw new MyException("单元格类型不是文本类型！");
				}
				row.getCell(0).setCellType(CellType.STRING);
				row.getCell(1).setCellType(CellType.STRING);
				row.getCell(2).setCellType(CellType.STRING);
				row.getCell(3).setCellType(CellType.STRING);
				row.getCell(4).setCellType(CellType.STRING);
				// 获取第一个单元格的内容
				String resumeId = row.getCell(0).getStringCellValue();
				// 获取第二个单元格的内容
				String schoolName = row.getCell(1).getStringCellValue();
				String major = row.getCell(2).getStringCellValue();
				String beginTime = row.getCell(3).getStringCellValue();
				String endTime = row.getCell(4).getStringCellValue();
				String describe = row.getCell(5).getStringCellValue();
				form.setResumeId(resumeId);
				form.setSchoolName(schoolName);
				form.setMajor(major);
				form.setBeginTime(beginTime);
				form.setEndTime(endTime);
				form.setEducationDescribe(describe);
				educationBackgroundFormList.add(form);
			}
			for (EducationBackgroundForm form : educationBackgroundFormList) {
				applicantService.insertEducationBackground(form);
			}
		}
		return ResultVOUtil.success();
	}
}