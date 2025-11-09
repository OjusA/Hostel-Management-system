package com.hostel.config;

import com.hostel.model.*;
import com.hostel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private FeeRepository feeRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private ComplaintRepository complaintRepo;

    @Override
    public void run(String... args) throws Exception {

        // --- Add Students ---
        Student s1 = new Student("John Doe", "A101", "john@example.com", "9876543210");
        Student s2 = new Student("Jane Smith", "A102", "jane@example.com", "9876501234");
        Student s3 = new Student("Robert Brown", "A103", "robert@example.com", "9876523456");
        studentRepo.saveAll(Arrays.asList(s1, s2, s3));

        // --- Add Rooms ---
        Room r1 = new Room("A101", 3, 1);
        Room r2 = new Room("A102", 3, 2);
        Room r3 = new Room("A103", 3, 1);
        roomRepo.saveAll(Arrays.asList(r1, r2, r3));

        // --- Add Fee Payments ---
        FeePayment f1 = new FeePayment(1L, 5000.0, LocalDate.now().minusDays(5));
        FeePayment f2 = new FeePayment(2L, 5500.0, LocalDate.now().minusDays(3));
        feeRepo.saveAll(Arrays.asList(f1, f2));

        // --- Add Attendance Records ---
        AttendanceRecord att1 = new AttendanceRecord(1L, LocalDate.now(), "Present");
        AttendanceRecord att2 = new AttendanceRecord(2L, LocalDate.now(), "Absent");
        attendanceRepo.saveAll(Arrays.asList(att1, att2));

        // --- Add Complaints ---
        Complaint c1 = new Complaint(1L, "Water Leakage", "Pipe is leaking in bathroom", "Pending");
        Complaint c2 = new Complaint(2L, "WiFi not working", "No connectivity in room A102", "Resolved");
        complaintRepo.saveAll(Arrays.asList(c1, c2));

        System.out.println("✅ Sample data loaded successfully!");
    }
}
