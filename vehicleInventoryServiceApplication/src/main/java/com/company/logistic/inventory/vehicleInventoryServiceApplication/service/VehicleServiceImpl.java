package com.company.logistic.inventory.vehicleInventoryServiceApplication.service;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.dto.*;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.exception.VehicleNotFoundException;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.model.Vehicle;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.repository.VehicleRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleResponseDto createVehicle(VehicleCreateRequestDto request) {
        if(vehicleRepository.existsByRegistrationNumber(request.getRegistrationNumber())){
            throw new IllegalArgumentException(
                    "vehicle already exists with registration number"
                    +request.getRegistrationNumber());

        }
        Vehicle vehicle1 = Vehicle.builder()
                .registrationNumber(request.getRegistrationNumber())
                .vehicleType(request.getVehicleType())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .capacity(request.getCapacity())
                .insuranceExpiryDate(request.getInsuranceExpiryDate())
                .permitExpiryDate(request.getPermitExpiryDate())
                .status(VehicleStatus.AVAILABLE)
                .build();

        return mapToResponse(vehicleRepository.save(vehicle1));
    }

    @Override
    public VehicleResponseDto updateVehicle(Long vehicleId, VehicleUpdateRequestDto request) {
        Vehicle vehicle2=vehicleRepository.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));

        vehicle2.setVehicleType(request.getVehicleType());
        vehicle2.setManufacturer(request.getManufacturer());
        vehicle2.setModel(request.getModel());
        vehicle2.setCapacity(request.getCapacity());
        vehicle2.setInsuranceExpiryDate(request.getInsuranceExpiryDate());
        vehicle2.setPermitExpiryDate(request.getPermitExpiryDate());

        return mapToResponse(vehicle2);
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleResponseDto getVehicleById(Long vehicleId) {
        Vehicle vehicle3=vehicleRepository.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));
        return mapToResponse(vehicle3);
    }





    @Override
    @Transactional(readOnly = true)
    public Page<VehicleResponseDto> getVehiclesByStatus(String status, Pageable pageable) {

        VehicleStatus vehicleStatus=VehicleStatus.valueOf(status.toUpperCase());
        return vehicleRepository
                .findByStatus(vehicleStatus, pageable)
                .map(this::mapToResponse);
    }




    @Override
    public void updateVehicleStatus(Long vehicleId, VehicleStatusUpdateDto request) {

        Vehicle vehicle5=vehicleRepository.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));

        vehicle5.setStatus(request.getStatus());
    }





    @Override
    public void deleteVehicle(Long vehicleId) {

        Vehicle vehicle6=vehicleRepository.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));

        vehicleRepository.delete(vehicle6);
    }




    @Override
    @Transactional(readOnly = true)
    public VehicleAvailabilityResponseDto checkAvailability(Long vehicleId) {
        Vehicle vehicle7= vehicleRepository.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));

        boolean available=vehicle7.getStatus()==VehicleStatus.AVAILABLE;


        return VehicleAvailabilityResponseDto.builder()
                .vehicleId(vehicle7.getVehicleId())
                .available(available)
                .build();
    }




    private VehicleResponseDto mapToResponse(Vehicle vehicle){
        return VehicleResponseDto.builder()
                .vehicleId(vehicle.getVehicleId())
                .registrationNumber(vehicle.getRegistrationNumber())
                .vehicleType(vehicle.getVehicleType())
                .manufacturer(vehicle.getManufacturer())
                .model(vehicle.getModel())
                .capacity(vehicle.getCapacity())
                .status(vehicle.getStatus())
                .insuranceExpiryDate(vehicle.getInsuranceExpiryDate())
                .permitExpiryDate(vehicle.getPermitExpiryDate())
                .build();
    }
}
