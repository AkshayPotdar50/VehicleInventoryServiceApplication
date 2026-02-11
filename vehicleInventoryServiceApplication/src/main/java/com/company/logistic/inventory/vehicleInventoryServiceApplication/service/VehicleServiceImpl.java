package com.company.logistic.inventory.vehicleInventoryServiceApplication.service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public class VehicleServiceImpl implements VehicleService{
    @Override
    public VehicleResponseDto createVehicle(VehicleCreateRequestDto request) {
        return null;
    }

    @Override
    public VehicleResponseDto updateVehicle(Long vehicleId, VehicleUpdateRequestDto request) {
        return null;
    }

    @Override
    public VehicleResponseDto getVehicleById(Long vehicleId) {
        return null;
    }

    @Override
    public Page<VehicleResponseDto> getVehiclesByStatus(String status, Pageable pageable) {
        return null;
    }

    @Override
    public void updateVehicleStatus(Long vehicleId, VehicleStatusUpdateDto request) {

    }

    @Override
    public void deleteVehicle(Long vehicleId) {

    }

    @Override
    public VehicleAvailabilityResponseDto checkAvailability(Long vehicleId) {
        return null;
    }
}
