package com.example.Micro.VehicleDispatchService.entity;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name="trip_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="trip_id", nullable = false,
    foreignKey =@ForeignKey(name="fk_trip_history_trip"))
    private Trip trip;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TripStatus status;

    @Column(nullable = false)
    private LocalDateTime changedAt;



    @PrePersist
    public void onCreate(){
        this.changedAt=LocalDateTime.now();
    }

}
