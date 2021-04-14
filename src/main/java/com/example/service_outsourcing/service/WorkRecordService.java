package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.AchievementForm;
import com.example.service_outsourcing.form.AttendanceForm;
import com.example.service_outsourcing.form.EvaluateForm;
import com.example.service_outsourcing.form.WorkRecordForm;
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
	 * 浏览单个工作记录
	 * @param recordId
	 * @return
	 */
	ResultVO browseWorkRecord(String recordId);

	ResultVO getAllWorkRecord();
}
