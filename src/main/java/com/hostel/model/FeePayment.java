package com.hostel.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fee_payments")
public class FeePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Double amount;
    private LocalDate paymentDate;

    public FeePayment() {}

    // ✅ Constructor used in DataLoader
    public FeePayment(Long studentId, Double amount, LocalDate paymentDate) {
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // ✅ Optional full constructor
    public FeePayment(Long id, Long studentId, Double amount, LocalDate paymentDate) {
        this.id = id;
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
}
