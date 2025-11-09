package com.hostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostel.model.Student;

public interface Repository extends JpaRepository<Student, Long> {
}
