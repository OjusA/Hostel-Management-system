package com.hostel.controller;

import com.hostel.model.AttendanceRecord;
import com.hostel.model.Student;
import com.hostel.repository.AttendanceRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/attendance")
    public String viewAttendance(Model model) {
        List<AttendanceRecord> attendanceList = attendanceRepository.findAll();
        List<Student> students = studentRepository.findAll();

        // Create a map of studentId -> studentName
        Map<Long, String> studentNameMap = students.stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));

        model.addAttribute("attendanceList", attendanceList);
        model.addAttribute("studentNameMap", studentNameMap);
        return "attendance_list";
    }
}
