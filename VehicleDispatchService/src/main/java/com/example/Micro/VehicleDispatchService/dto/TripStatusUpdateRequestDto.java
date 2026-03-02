package com.example.Micro.VehicleDispatchService.dto;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripStatusUpdateRequestDto {

    @NotNull
    private TripStatus status;
}
