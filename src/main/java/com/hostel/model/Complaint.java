package com.hostel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String title;
    private String description;
    private String status;

    public Complaint() {}

    // ✅ Constructor used in DataLoader
    public Complaint(Long studentId, String title, String description, String status) {
        this.studentId = studentId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // ✅ Optional full constructor
    public Complaint(Long id, Long studentId, String title, String description, String status) {
        this.id = id;
        this.studentId = studentId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
