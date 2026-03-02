package com.example.Micro.VehicleDispatchService.dto;

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
