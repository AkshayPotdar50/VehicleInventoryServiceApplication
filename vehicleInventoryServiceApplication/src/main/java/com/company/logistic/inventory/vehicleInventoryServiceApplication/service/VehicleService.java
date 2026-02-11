package com.company.logistic.inventory.vehicleInventoryServiceApplication.service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface VehicleService {

    VehicleResponseDto createVehicle(VehicleCreateRequestDto request);

    VehicleResponseDto updateVehicle(Long vehicleId,
                                     VehicleUpdateRequestDto request);

    VehicleResponseDto getVehicleById(Long vehicleId);

    Page<VehicleResponseDto> getVehiclesByStatus(String status, Pageable pageable);

    void updateVehicleStatus(Long vehicleId, VehicleStatusUpdateDto request);

    void deleteVehicle(Long vehicleId);

    VehicleAvailabilityResponseDto checkAvailability(Long vehicleId);


}
