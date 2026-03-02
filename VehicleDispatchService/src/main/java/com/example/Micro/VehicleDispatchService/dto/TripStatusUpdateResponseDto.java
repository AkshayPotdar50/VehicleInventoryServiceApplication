package com.example.Micro.VehicleDispatchService.dto;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripStatusUpdateResponseDto {

    private Long tripId;

    private TripStatus oldStatus;

    private TripStatus newStatus;

    private LocalDateTime updatedAt;
}
