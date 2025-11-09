package com.hostel.controller;

import com.hostel.model.Complaint;
import com.hostel.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @GetMapping("/complaints")
    public String showComplaints(Model model) {
        List<Complaint> complaints = complaintRepository.findAll();
        model.addAttribute("title", "Complaint Management");
        model.addAttribute("complaints", complaints);
        return "complaints";
    }
}
