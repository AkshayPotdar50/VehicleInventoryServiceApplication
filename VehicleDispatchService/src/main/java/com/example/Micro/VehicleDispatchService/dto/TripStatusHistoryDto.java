package com.example.Micro.VehicleDispatchService.dto;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripStatusHistoryDto {

    private TripStatus status;

    private LocalDateTime changedAt;

}
