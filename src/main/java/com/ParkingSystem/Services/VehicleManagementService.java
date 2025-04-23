package com.ParkingSystem.Services;

import com.ParkingSystem.DTO.VehicleDTO;
import com.ParkingSystem.Entities.Vehicle;
import com.ParkingSystem.Repositories.VehicleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleManagementService {
    @Autowired
    private VehicleManagementRepository vehicleManagementRepository;

    //Get all Vehicles
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
      List<Vehicle>vehicles=vehicleManagementRepository.findAll();
      return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    //Register a new Vehicle
    public ResponseEntity<Vehicle> createVehicle(Vehicle vehicle) {
        vehicleManagementRepository.save(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    //Delete a Vehicle
    public ResponseEntity<String> deleteVehicle(Long id) {
        Optional<Vehicle> vehicle = vehicleManagementRepository.findById(id);

        if (vehicle.isPresent()) {
            vehicleManagementRepository.deleteById(id);
            String successMessage = "Vehicle id " + id + " deleted successfully";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            String notFoundMessage = "Vehicle id " + id + " not found";
            return new ResponseEntity<>(notFoundMessage, HttpStatus.NOT_FOUND);
        }
    }

    //Update A Vehicle
    public ResponseEntity<String> updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleManagementRepository.findById(id);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            // Update the vehicle's fields from the DTO
            vehicle.setPlateNumber(vehicleDTO.getPlateNumber());

            // Save the updated vehicle
            vehicleManagementRepository.save(vehicle);

            // Return success response
            return ResponseEntity.ok("Vehicle updated successfully");
        }

        // Return not found if vehicle doesn't exist
        return ResponseEntity.notFound().build();
    }
}
