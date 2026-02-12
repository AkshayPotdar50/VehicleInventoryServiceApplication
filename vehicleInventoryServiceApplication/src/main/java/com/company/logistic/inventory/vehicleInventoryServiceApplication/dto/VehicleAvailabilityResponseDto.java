package com.company.logistic.inventory.vehicleInventoryServiceApplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleAvailabilityResponseDto {

    private Long vehicleId;
    private boolean available;
}
