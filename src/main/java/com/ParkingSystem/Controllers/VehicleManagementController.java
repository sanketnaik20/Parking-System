package com.ParkingSystem.Controllers;

import com.ParkingSystem.DTO.VehicleDTO;
import com.ParkingSystem.Entities.Vehicle;
import com.ParkingSystem.Services.VehicleManagementService;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleManagementController {

    @Autowired
    VehicleManagementService vehicleManagementService;

    //Get all Vehicles
    @GetMapping("/vehicles")
    ResponseEntity<List<Vehicle>> getAllVehicles() {
    return vehicleManagementService.getAllVehicles();
    }

    // Register a New Vehicle
    @PostMapping("/vehicles")
   ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleManagementService.createVehicle(vehicle);
    }

    //Delete a Vehicle
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> updateVehicle(@PathVariable Long id) {
        return vehicleManagementService.deleteVehicle(id);
    }

    //Update a vehicle
    @PutMapping("/vehicle/{id}")
    ResponseEntity<String> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicle) {
        return vehicleManagementService.updateVehicle(id,vehicle);
    }
}
