package com.ParkingSystem.Repositories;

import com.ParkingSystem.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleManagementRepository extends JpaRepository<Vehicle, Long> {

}
