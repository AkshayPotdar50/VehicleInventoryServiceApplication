package com.company.logistic.inventory.vehicleInventoryServiceApplication.dto;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleUpdateRequestDto {

    @NotNull
    private VehicleType vehicleType;

    @Size(max=50)
    private String Manufacturer;

    @Size(max=50)
    private String model;

    @Positive
    private Integer capacity;

    @NotNull
    @Future
    private LocalDate insuranceExpiryDate;

    @NotNull
    @Future
    private LocalDate permitExpiryDate;
}
