package com.hostel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNo;
    private int capacity;
    private int occupied;

    public Room() {}

    // ✅ Constructor used in DataLoader
    public Room(String roomNo, int capacity, int occupied) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    // ✅ Optional full constructor
    public Room(Long id, String roomNo, int capacity, int occupied) {
        this.id = id;
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getOccupied() { return occupied; }
    public void setOccupied(int occupied) { this.occupied = occupied; }
}
