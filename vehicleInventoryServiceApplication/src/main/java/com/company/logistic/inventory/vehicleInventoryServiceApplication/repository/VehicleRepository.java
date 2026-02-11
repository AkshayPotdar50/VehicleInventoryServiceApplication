package com.company.logistic.inventory.vehicleInventoryServiceApplication.repository;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
