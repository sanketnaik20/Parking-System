package com.ParkingSystem.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VehicleDTO {
    private String plateNumber;
}
