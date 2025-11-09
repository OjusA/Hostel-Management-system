package com.hostel.repository;

import com.hostel.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    // Find complaints for a specific student
    List<Complaint> findByStudentId(Long studentId);

    // Delete all complaints for a specific student
    void deleteAllByStudentId(Long studentId);
}
