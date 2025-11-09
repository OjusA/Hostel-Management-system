package com.hostel.service;

import com.hostel.model.AttendanceRecord;
import com.hostel.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    // ✅ Return all attendance records
    public List<AttendanceRecord> listAll() {
        return repo.findAll();
    }

    // ✅ Mark attendance for a student
    public void markAttendance(Long studentId, boolean present) {
        String status = present ? "Present" : "Absent";
        AttendanceRecord record = new AttendanceRecord(studentId, LocalDate.now(), status);
        repo.save(record);
    }

    // ✅ Get all attendance records for a specific student
    public List<AttendanceRecord> getByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    // ✅ Delete all records for a student
    public void deleteByStudent(Long studentId) {
        repo.deleteAllByStudentId(studentId);
    }
}
