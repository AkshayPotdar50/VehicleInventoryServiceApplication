package com.company.logistic.inventory.vehicleInventoryServiceApplication.repository;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.model.VehicleDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDocumentRepository extends JpaRepository<VehicleDocument, Long> {

    List<VehicleDocument> findByVehicle_VehicleId(Long vehicleId);
}
