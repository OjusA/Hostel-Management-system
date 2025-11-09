package com.hostel.service;

import com.hostel.model.Student;
import com.hostel.repository.AttendanceRepository;
import com.hostel.repository.ComplaintRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private AttendanceRepository attendance;

    @Autowired
    private ComplaintRepository complaints;

    // ✅ Fetch all students
    public List<Student> listAll() {
        return repo.findAll();
    }

    // ✅ Save or update a student
    public void save(Student student) {
        repo.save(student);
    }

    // ✅ Get a student by ID
    public Student get(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ Delete a student and related records
    public void deleteStudent(Long id) {
        Student student = repo.findById(id).orElse(null);
        if (student != null) {
            // Clean up related data before deleting
            attendance.deleteAllByStudentId(student.getId());
            complaints.deleteAllByStudentId(student.getId());
            repo.delete(student);
        }
    }

    // ✅ Update existing student details
    public Student updateStudent(Long id, Student updated) {
        Student existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setRoomNo(updated.getRoomNo());
            existing.setEmail(updated.getEmail());
            existing.setPhone(updated.getPhone());
            return repo.save(existing);
        }
        return null;
    }
}
