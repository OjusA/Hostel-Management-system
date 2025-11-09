package com.hostel.service;

import com.hostel.model.FeePayment;
import com.hostel.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository repo;

    // ✅ Fetch all fee payments
    public List<FeePayment> getAll() {
        return repo.findAll();
    }

    // ✅ Fetch fee records for a student
    public List<FeePayment> getByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    // ✅ Record a new payment
    public FeePayment addFee(FeePayment payment) {
        return repo.save(payment);
    }

    // ✅ Update payment info
    public FeePayment updateFee(Long id, FeePayment newFee) {
        return repo.findById(id).map(f -> {
            f.setAmount(newFee.getAmount());
            f.setPaymentDate(newFee.getPaymentDate());
            f.setStudentId(newFee.getStudentId());
            return repo.save(f);
        }).orElse(null);
    }
}
