package com.hostel.service;

import com.hostel.model.Complaint;
import com.hostel.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repo;

    // ✅ Fetch all complaints
    public List<Complaint> getAll() {
        return repo.findAll();
    }

    // ✅ Fetch complaints for a given student
    public List<Complaint> getByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    // ✅ File a new complaint
    public Complaint addComplaint(Complaint complaint) {
        return repo.save(complaint);
    }

    // ✅ Update complaint status
    public Complaint updateStatus(Long id, String newStatus) {
        return repo.findById(id).map(c -> {
            c.setStatus(newStatus);
            return repo.save(c);
        }).orElse(null);
    }

    // ✅ Delete all complaints for a student
    public void deleteByStudent(Long studentId) {
        repo.deleteAllByStudentId(studentId);
    }
}
