package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.*;
import org.springframework.stereotype.Service;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/13 10:50
 */
@Service
public interface WorkRecordService {
	/**
	 * 添加工作记录
	 * @param form
	 * @return
	 */
	ResultVO insertWorkRecord(WorkRecordForm form);

	/**
	 * 删除工作记录
	 * @param recordId
	 * @return
	 */
	ResultVO deleteWorkRecord(String recordId);

	ResultVO updateWorkRecord(UpdateWorkRecordForm form);

	/**
	 * 添加绩效
	 * @param form
	 * @return
	 */
	ResultVO insertAchievement(AchievementForm form);

	/**
	 * 删除绩效
	 * @param achievementId
	 * @return
	 */
	ResultVO deleteAchievement(String achievementId);

	/**
	 * 更新绩效
	 * @param form
	 * @return
	 */
	ResultVO updateAchievement(UpdateAchievementForm form);

	/**
	 * 获得单个绩效
	 * @param achievementId
	 * @return
	 */
	ResultVO getAchievement(String achievementId);

	/**
	 * 获得一份工作记录中的所有绩效
	 * @param recordId
	 * @return
	 */
	ResultVO getAllAchievement(String recordId);

	/**
	 * 添加评价
	 * @param form
	 * @return
	 */
	ResultVO insertEvaluate(EvaluateForm form);

	/**
	 * 删除评价
	 * @param evaluateId
	 * @return
	 */
	ResultVO deleteEvaluate(String evaluateId);

	/**
	 * 更新评价
	 * @param form
	 * @return
	 */
	ResultVO updateEvaluate(UpdateEvaluateForm form);

	/**
	 * 获得单个评价
	 * @param evaluateId
	 * @return
	 */
	ResultVO getEvaluate(String evaluateId);

	/**
	 * 获得一份工作记录中的所有评价
	 * @param recordId
	 * @return
	 */
	ResultVO getAllAEvaluate(String recordId);

	/**
	 * 添加考勤
	 * @param form
	 * @return
	 */
	ResultVO insertAttendance(AttendanceForm form);

	/**
	 * 删除考勤
	 * @param attendanceId
	 * @return
	 */
	ResultVO deleteAttendance(String attendanceId);

	/**
	 * 更新考勤记录
	 * @param form
	 * @return
	 */
	ResultVO updateAttendance(UpdateAttendanceForm form);

	/**
	 * 获得单个考勤记录
	 * @param attendanceId
	 * @return
	 */
	ResultVO getAttendance(String attendanceId);

	/**
	 * 获得一份工作记录中的所有考勤记录
	 * @param recordId
	 * @return
	 */
	ResultVO getAllAttendance(String recordId);

	/**
	 * 浏览单个工作记录
	 * @param recordId
	 * @return
	 */
	ResultVO browseWorkRecord(String recordId);

	/**
	 * 获得所有工作记录
	 * @return
	 */
	ResultVO getAllWorkRecord(String employeeId);
}
