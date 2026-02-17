package com.company.logistic.inventory.vehicleInventoryServiceApplication.dto;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleResponseDto {

    private Long vehicleId;

    private String registrationNumber;

    private VehicleType vehicleType;

    private String manufacturer;

    private String model;

    private Integer capacity;

    private VehicleStatus status;

    private LocalDate insuranceExpiryDate;

    private LocalDate permitExpiryDate;


}
