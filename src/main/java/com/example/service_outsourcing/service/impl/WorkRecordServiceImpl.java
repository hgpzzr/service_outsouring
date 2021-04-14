package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.*;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.AchievementForm;
import com.example.service_outsourcing.form.AttendanceForm;
import com.example.service_outsourcing.form.EvaluateForm;
import com.example.service_outsourcing.form.WorkRecordForm;
import com.example.service_outsourcing.mapper.*;
import com.example.service_outsourcing.service.WorkRecordService;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/13 10:51
 */
@Service
@Slf4j
public class WorkRecordServiceImpl implements WorkRecordService {
	@Autowired
	private WorkRecordMapper workRecordMapper;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private AchievementMapper achievementMapper;
	@Autowired
	private EvaluateMapper evaluateMapper;
	@Autowired
	private AttendanceMapper attendanceMapper;
	@Autowired
	private GenerateIdUtil generateIdUtil;

	@Override
	public ResultVO insertWorkRecord(WorkRecordForm form) {
		if(employeeMapper.selectByPrimaryKey(form.getEmployeeId())==null){
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_NOT_EXIST_ERROR);
		}
		if(organizationMapper.selectByPrimaryKey(form.getOrganizationId())==null){
			return ResultVOUtil.error(ResultEnum.ORGANIZATION_NOT_EXIST_ERROR);
		}
		if(postMapper.selectByPrimaryKey(form.getPostId())==null){
			return ResultVOUtil.error(ResultEnum.POST_NOT_EXIST_ERROR);
		}
		// 判断时间冲突
		// 判断开始时间是否晚于结束时间
		if(form.getBeginTime().compareTo(form.getEndTime()) >0 ){
			log.error("【添加工作记录】：开始时间比结束时间晚，添加失败");
			return ResultVOUtil.error(ResultEnum.DATE_ORDER_ERROR);
		}
		// 判断时间是否重叠
		List<WorkRecord> workRecords = workRecordMapper.selectByEmployeeId(form.getEmployeeId());
		for (int i = 0; i < workRecords.size(); i++) {
			WorkRecord workRecord = workRecords.get(i);
			if(workRecord.getBeginTime().compareTo(form.getEndTime())<=0 && workRecord.getBeginTime().compareTo(form.getBeginTime())>=0
					|| workRecord.getEndTime().compareTo(form.getBeginTime())>=0&&workRecord.getEndTime().compareTo(form.getEndTime())<=0){
				log.error("【添加工作记录】：时间重叠，添加失败");
				return ResultVOUtil.error(ResultEnum.DATE_OVERLAP_ERROR);
			}
		}
		// 存入数据库
		WorkRecord workRecord = new WorkRecord();
		BeanUtils.copyProperties(form,workRecord);
//		String recordId = GenerateIdUtil.getRecordId(workRecordMapper);
		String recordId = generateIdUtil.getRandomId(workRecordMapper, "WR");
		workRecord.setRecordId(recordId);
		int insert = workRecordMapper.insert(workRecord);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success(recordId);
	}

	@Override
	public ResultVO deleteWorkRecord(String recordId) {
		if(workRecordMapper.selectByPrimaryKey(recordId)==null){
			return ResultVOUtil.error(ResultEnum.WORK_RECORD_NOT_EXIST_ERROR);
		}
		int delete = workRecordMapper.deleteByPrimaryKey(recordId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertAchievement(AchievementForm form) {
		if(workRecordMapper.selectByPrimaryKey(form.getRecordId())==null){
			return ResultVOUtil.error(ResultEnum.WORK_RECORD_NOT_EXIST_ERROR);
		}
		Achievement achievement = new Achievement();
		BeanUtils.copyProperties(form,achievement);
//		String achievementId = GenerateIdUtil.getAchievementId(achievementMapper);
		String achievementId = generateIdUtil.getRandomId(achievementMapper, "AC");
		achievement.setAchievementId(achievementId);
		int insert = achievementMapper.insert(achievement);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success(achievementId);
	}

	@Override
	public ResultVO deleteAchievement(String achievementId) {
		if(achievementMapper.selectByPrimaryKey(achievementId)==null){
			return ResultVOUtil.error(ResultEnum.ACHIEVEMENT_NOT_EXIST_ERROR);
		}
		int delete = achievementMapper.deleteByPrimaryKey(achievementId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertEvaluate(EvaluateForm form) {
		if(workRecordMapper.selectByPrimaryKey(form.getRecordId())==null){
			return ResultVOUtil.error(ResultEnum.WORK_RECORD_NOT_EXIST_ERROR);
		}
		Evaluate evaluate = new Evaluate();
		BeanUtils.copyProperties(form,evaluate);
//		String evaluateId = GenerateIdUtil.getEvaluateId(evaluateMapper);
		String evaluateId = generateIdUtil.getRandomId(evaluateMapper, "EV");
		evaluate.setEvaluateId(evaluateId);
		int insert = evaluateMapper.insert(evaluate);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success(evaluateId);
	}

	@Override
	public ResultVO deleteEvaluate(String evaluateId) {
		if(evaluateMapper.selectByPrimaryKey(evaluateId)==null){
			return ResultVOUtil.error(ResultEnum.EVALUATE_NOT_EXIST_ERROR);
		}
		int delete = evaluateMapper.deleteByPrimaryKey(evaluateId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO insertAttendance(AttendanceForm form) {
		if(workRecordMapper.selectByPrimaryKey(form.getRecordId())==null){
			return ResultVOUtil.error(ResultEnum.WORK_RECORD_NOT_EXIST_ERROR);
		}
		Attendance attendance = new Attendance();
		BeanUtils.copyProperties(form,attendance);
		DecimalFormat decimalFormat = new DecimalFormat("######0.00");
		double absenceRate = form.getAbsenceNum()*1.0/form.getAttendanceNum();
		attendance.setAbsenceRate(Double.valueOf(decimalFormat.format(absenceRate)));
		double lateRate = form.getLateNum()*1.0/form.getAttendanceNum();
		attendance.setLateRate(Double.valueOf(decimalFormat.format(lateRate)));
		double leaveRate = form.getLeaveNum()*1.0/form.getAttendanceNum();
		attendance.setLeaveRate(Double.valueOf(decimalFormat.format(leaveRate)));
		double leaveEarlyRate = form.getLeaveEarlyNum()*1.0/form.getAttendanceNum();
		attendance.setLeaveEarlyRate(Double.valueOf(decimalFormat.format(leaveEarlyRate)));
//		String attendanceId = GenerateIdUtil.getAttendanceId(attendanceMapper);
		String attendanceId = generateIdUtil.getRandomId(attendanceMapper, "AT");
		attendance.setAttendanceId(attendanceId);
		int insert = attendanceMapper.insert(attendance);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success(attendanceId);
	}

	@Override
	public ResultVO deleteAttendance(String attendanceId) {
		if(attendanceMapper.selectByPrimaryKey(attendanceId)==null){
			return ResultVOUtil.error(ResultEnum.ATTENDANCE_NOT_EXIST_ERROR);
		}
		int delete = attendanceMapper.deleteByPrimaryKey(attendanceId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO browseWorkRecord(String recordId) {
		WorkRecord workRecord = workRecordMapper.selectByPrimaryKey(recordId);
		List<Achievement> achievements = achievementMapper.selectByRecordId(recordId);
		List<Evaluate> evaluates = evaluateMapper.selectByRecordId(recordId);
		List<Attendance> attendances = attendanceMapper.selectByRecordId(recordId);
		Map map = new HashMap();
		map.put("workRecord",workRecord);
		map.put("achievements",achievements);
		map.put("evaluates",evaluates);
		map.put("attendances",attendances);
		return ResultVOUtil.success(map);
	}
}
