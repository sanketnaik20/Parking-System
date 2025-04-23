package com.ParkingSystem.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plate number is required")
    private String plateNumber;

    @OneToMany(mappedBy = "vehicle")
    private List<Parking> parkings;

}
