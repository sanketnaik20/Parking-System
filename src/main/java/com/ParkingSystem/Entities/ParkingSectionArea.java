package com.ParkingSystem.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ParkingSectionArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parkSectionArea;
    private Integer capacity;

    @OneToMany(mappedBy = "parkingSectionArea")
    private List<Parking> parkings;
}

