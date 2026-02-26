package com.example.Micro.VehicleDispatchService.entity;

import com.example.Micro.VehicleDispatchService.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(name="vehicle_id", nullable = false)
    private Long vehicleId;

    @Column(nullable = false, length = 100)
    private String driverName;

    @Column(nullable = false, length = 100)
    private String source;

    @Column(nullable = false, length = 100)
    private String destination;

    @Column(nullable = false)
    private LocalDate scheduledDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TripStatus status;

    @OneToMany(
            mappedBy = "trip",
            cascade=CascadeType.ALL,
            orphanRemoval = true,
            fetch=FetchType.LAZY
    ) private List<TripStatusHistory> statusHistory;

    @Column(updatable = false)
    private LocalDate createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDate.now();
        this.updatedAt=LocalDateTime.now();
        if(this.status==null){
            this.status= TripStatus.SCHEDULED;
        }
    }


    @PreUpdate
    public void onUpdate(){
        this.updatedAt=LocalDateTime.now();
    }


}
