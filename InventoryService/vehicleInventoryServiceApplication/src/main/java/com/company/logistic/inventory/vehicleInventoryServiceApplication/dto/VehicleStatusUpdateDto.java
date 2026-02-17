package com.company.logistic.inventory.vehicleInventoryServiceApplication.dto;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleStatusUpdateDto {

    @NotNull
    private VehicleStatus status;
}
