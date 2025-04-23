package com.ParkingSystem.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    private LocalDateTime parkIn;
    private LocalDateTime parkOut;

    private String gateIn;
    private String gateOut;

    @ManyToOne
    @JoinColumn(name = "park_place_id")
    private ParkingSectionArea parkingSectionArea;
}

