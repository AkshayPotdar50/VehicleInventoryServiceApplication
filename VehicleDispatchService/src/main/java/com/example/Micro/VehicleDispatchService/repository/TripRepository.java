package com.example.Micro.VehicleDispatchService.repository;

import com.example.Micro.VehicleDispatchService.entity.Trip;
import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByStatus(TripStatus status);
}
