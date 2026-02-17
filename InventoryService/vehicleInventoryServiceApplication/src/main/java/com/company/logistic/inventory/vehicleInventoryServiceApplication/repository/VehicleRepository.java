package com.company.logistic.inventory.vehicleInventoryServiceApplication.repository;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle>findByRegistrationNumber(String registrationNumber);

    boolean existsByRegistrationNumber(String registrationNumber);

    Page<Vehicle> findByStatus(VehicleStatus status, Pageable pageable);
}
