package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Attendance;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AttendanceMapper {
    int deleteByPrimaryKey(String attendanceId);

    int insert(Attendance record);

    Attendance selectByPrimaryKey(String attendanceId);

    List<Attendance> selectAll();

    int updateByPrimaryKey(Attendance record);
}