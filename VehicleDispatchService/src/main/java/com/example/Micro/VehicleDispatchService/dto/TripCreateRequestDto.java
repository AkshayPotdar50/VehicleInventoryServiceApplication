package com.example.Micro.VehicleDispatchService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripCreateRequestDto {

    @NotNull
    private Long vehicleId;

    @NotBlank
    private String driverName;

    @NotBlank
    private String source;

    @NotBlank
    private String destination;

    @NotNull
    private LocalDate scheduledDate;


}
