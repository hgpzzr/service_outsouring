package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Attendance implements Serializable {
    private String attendanceId;

    private String recordId;

    private Integer attendanceNum;

    private Integer absenceNum;

    private Double absenceRate;

    private Integer lateNum;

    private Double lateRate;

    private Integer leaveNum;

    private Double leaveRate;

    private Integer leaveEarlyNum;

    private Double leaveEarlyRate;

    private String comprehensiveRating;

    private static final long serialVersionUID = 1L;

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId == null ? null : attendanceId.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public Integer getAttendanceNum() {
        return attendanceNum;
    }

    public void setAttendanceNum(Integer attendanceNum) {
        this.attendanceNum = attendanceNum;
    }

    public Integer getAbsenceNum() {
        return absenceNum;
    }

    public void setAbsenceNum(Integer absenceNum) {
        this.absenceNum = absenceNum;
    }

    public Double getAbsenceRate() {
        return absenceRate;
    }

    public void setAbsenceRate(Double absenceRate) {
        this.absenceRate = absenceRate;
    }

    public Integer getLateNum() {
        return lateNum;
    }

    public void setLateNum(Integer lateNum) {
        this.lateNum = lateNum;
    }

    public Double getLateRate() {
        return lateRate;
    }

    public void setLateRate(Double lateRate) {
        this.lateRate = lateRate;
    }

    public Integer getLeaveNum() {
        return leaveNum;
    }

    public void setLeaveNum(Integer leaveNum) {
        this.leaveNum = leaveNum;
    }

    public Double getLeaveRate() {
        return leaveRate;
    }

    public void setLeaveRate(Double leaveRate) {
        this.leaveRate = leaveRate;
    }

    public Integer getLeaveEarlyNum() {
        return leaveEarlyNum;
    }

    public void setLeaveEarlyNum(Integer leaveEarlyNum) {
        this.leaveEarlyNum = leaveEarlyNum;
    }

    public Double getLeaveEarlyRate() {
        return leaveEarlyRate;
    }

    public void setLeaveEarlyRate(Double leaveEarlyRate) {
        this.leaveEarlyRate = leaveEarlyRate;
    }

    public String getComprehensiveRating() {
        return comprehensiveRating;
    }

    public void setComprehensiveRating(String comprehensiveRating) {
        this.comprehensiveRating = comprehensiveRating == null ? null : comprehensiveRating.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attendanceId=").append(attendanceId);
        sb.append(", recordId=").append(recordId);
        sb.append(", attendanceNum=").append(attendanceNum);
        sb.append(", absenceNum=").append(absenceNum);
        sb.append(", absenceRate=").append(absenceRate);
        sb.append(", lateNum=").append(lateNum);
        sb.append(", lateRate=").append(lateRate);
        sb.append(", leaveNum=").append(leaveNum);
        sb.append(", leaveRate=").append(leaveRate);
        sb.append(", leaveEarlyNum=").append(leaveEarlyNum);
        sb.append(", leaveEarlyRate=").append(leaveEarlyRate);
        sb.append(", comprehensiveRating=").append(comprehensiveRating);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}