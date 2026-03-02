package com.example.Micro.VehicleDispatchService.dto;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripResponseDto {

    private Long tripId;

    private Long vehicleId;

    private String driverName;

    private String source;

    private String destination;

    private LocalDate scheduledDate;

    private TripStatus status;

    private LocalDateTime createdAt;



}
