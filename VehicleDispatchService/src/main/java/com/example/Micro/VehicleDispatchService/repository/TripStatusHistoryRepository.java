package com.example.Micro.VehicleDispatchService.repository;

import com.example.Micro.VehicleDispatchService.entity.TripStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripStatusHistoryRepository extends JpaRepository<TripStatusHistory, Long> {

    List<TripStatusHistory> findByTrip_TripId(Long tripId);
}
