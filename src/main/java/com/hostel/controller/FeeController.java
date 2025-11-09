package com.hostel.controller;

import com.hostel.model.FeePayment;
import com.hostel.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeeController {

    @Autowired
    private FeeRepository feeRepository;

    @GetMapping("/fees")
    public String showFees(Model model) {
        List<FeePayment> fees = feeRepository.findAll();
        model.addAttribute("title", "Fee Management");
        model.addAttribute("fees", fees);
        return "fees";
    }
}
