package com.company.logistic.inventory.vehicleInventoryServiceApplication.controller;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.dto.*;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    private final VehicleServiceImpl vehicleService;


    //******************
    //create vehicle
    //******************

    @PostMapping
    public ResponseEntity<VehicleResponseDto> createVehicle(@Valid @RequestBody VehicleCreateRequestDto request){

        VehicleResponseDto responce=vehicleService.createVehicle(request);
        return new ResponseEntity<>(responce, HttpStatus.CREATED);

    }


    //******************
    //get vehicle by id
    //******************

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDto>getVehicleById(@PathVariable Long VehicleId){
       return ResponseEntity.ok(
               vehicleService.getVehicleById(VehicleId)
       );

    }


    //**********************
    //get vehicle by status
    //example:
    //  /api/v1/vehicles?status=AVAILABLE&page=0@size=10
    //-------------------------
   @GetMapping
   public ResponseEntity<Page<VehicleResponseDto>> getVehiclesByStatus(
            @RequestParam String status,
            @PageableDefault(size=10)Pageable pageable
            ){
        return ResponseEntity.ok(
                vehicleService.getVehiclesByStatus(status, pageable)
        );
    }




    //*********************
    //update vehicle master data
    //*********************
    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDto> updateVehicle(
            @PathVariable Long vehicleId,
            @Valid @RequestBody VehicleUpdateRequestDto request
            ){

        return ResponseEntity.ok(
                vehicleService.updateVehicle(vehicleId, request)
        );
    }




    //**************************
    //update only vehicle status
    //(used by dispatch service)
    //**************************
    @PutMapping("/{vehicleId}/status")
    public ResponseEntity<Void> updateVehicleStatus(
            @PathVariable Long vehicleId,
            @Valid @RequestBody VehicleStatusUpdateDto request)
            {

    vehicleService.updateVehicleStatus(vehicleId, request);
    return ResponseEntity.noContent().build();
    }




    //*****************
    //check availability
    //(used by dispatch services)
    //********************
    @GetMapping("/{vehicleId}/availability")
    public ResponseEntity<VehicleAvailabilityResponseDto> checkAvailability(
            @PathVariable Long vehicleId){

        return ResponseEntity.ok(
                vehicleService.checkAvailability(vehicleId)
        );
    }



    //**********************
    //Delete vehicle
    //**********************
    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(
            @PathVariable Long vehicleId
    ){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }
}
