package com.company.logistic.inventory.vehicleInventoryServiceApplication;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.dto.VehicleCreateRequestDto;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.dto.VehicleResponseDto;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleType;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.model.Vehicle;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.repository.VehicleRepository;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private VehicleCreateRequestDto createRequestDto;

    @BeforeEach
    void setUp(){
        createRequestDto=VehicleCreateRequestDto.builder()
                .registrationNumber("MH12AB1234")
                .vehicleType(VehicleType.TRUCK)
                .manufacturer("Tata")
                .model("Prima")
                .capacity(20)
                .insuranceExpiryDate(LocalDate.now().plusDays(30))
                .permitExpiryDate(LocalDate.now().plusDays(60))
                .build();
    }


    //************************************************
    //createVehicle -success created by ARP
    //************************************************
    @Test
    void createVehicle_shouldCreateVehicleSuccessfully() {

        when(vehicleRepository.existsByRegistrationNumber("MH12AB1234")).thenReturn(false);

        Vehicle savedVehicle = Vehicle.builder()
                .vehicleId(1L)
                .registrationNumber("MH12AB1234")
                .vehicleType(VehicleType.TRUCK)
                .manufacturer("Tata")
                .model("Prima")
                .capacity(20)
                .status(VehicleStatus.AVAILABLE)
                .insuranceExpiryDate(createRequestDto.getInsuranceExpiryDate())
                .permitExpiryDate(createRequestDto.getPermitExpiryDate())
                .build();

        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(savedVehicle);

        VehicleResponseDto responseDto=vehicleService.createVehicle(createRequestDto);

        assertNotNull(responseDto);
        assertEquals(1L, responseDto.getVehicleId());
        assertEquals("MH12AB1234", responseDto.getRegistrationNumber());
        assertEquals(VehicleStatus.AVAILABLE, responseDto.getStatus());

        verify(vehicleRepository,times(1))
                .save(any(Vehicle.class));
    }
}
