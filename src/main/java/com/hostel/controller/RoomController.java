package com.hostel.controller;

import com.hostel.model.Room;
import com.hostel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/rooms")
    public String showRooms(Model model) {
        try {
            List<Room> rooms = service.getAllRooms();
            model.addAttribute("rooms", rooms);
            return "rooms";  // → refers to templates/rooms.html
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "error"; // fallback page
        }
    }
}
