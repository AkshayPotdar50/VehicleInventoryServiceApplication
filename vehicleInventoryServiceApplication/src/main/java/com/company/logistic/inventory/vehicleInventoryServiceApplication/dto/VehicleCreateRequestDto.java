package com.company.logistic.inventory.vehicleInventoryServiceApplication.dto;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
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
public class VehicleCreateRequestDto {

    @NotBlank
    @Size(max=50)
    private String registrationNumber;

    @NotNull
    private VehicleType vehicleType;


   @Size(max=50)
   private String manufacturer;


   @Size(max=50)
   private String model;


   @Positive
   private Integer capacity;
    private LocalDate insuranceExpiryDate;
    private LocalDate permitExpiryDate;


}
