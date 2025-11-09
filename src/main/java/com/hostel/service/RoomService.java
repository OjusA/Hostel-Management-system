package com.hostel.service;

import com.hostel.model.Room;
import com.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    // ✅ Fetch all rooms
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    // ✅ Add a new room
    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    // ✅ Find a room by ID (roomNo may come as String from the controller/UI)
    public Optional<Room> getRoomById(String roomNo) {
        try {
            Long roomId = Long.parseLong(roomNo); // Convert String → Long safely
            return roomRepo.findById(roomId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID format: " + roomNo);
            return Optional.empty();
        }
    }

    // ✅ Update an existing room
    public Room updateRoom(String roomNo, Room updatedRoom) {
        try {
            Long roomId = Long.parseLong(roomNo);
            Optional<Room> existing = roomRepo.findById(roomId);

            if (existing.isPresent()) {
                Room room = existing.get();
                room.setRoomNo(updatedRoom.getRoomNo());
                room.setCapacity(updatedRoom.getCapacity());
                room.setOccupied(updatedRoom.getOccupied());
                return roomRepo.save(room);
            } else {
                System.out.println("Room not found with ID: " + roomNo);
                return null;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID format while updating: " + roomNo);
            return null;
        }
    }

    // ✅ Delete a room by ID
    public void deleteRoom(String roomNo) {
        try {
            Long roomId = Long.parseLong(roomNo);
            if (roomRepo.existsById(roomId)) {
                roomRepo.deleteById(roomId);
                System.out.println("Deleted room ID: " + roomId);
            } else {
                System.out.println("No room found with ID: " + roomNo);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID format while deleting: " + roomNo);
        }
    }
}
