package com.company.logistic.inventory.vehicleInventoryServiceApplication.model;

import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleStatus;
import com.company.logistic.inventory.vehicleInventoryServiceApplication.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name="vehicles",
        uniqueConstraints = {
                @UniqueConstraint(name=" uk_vehicles_reg_no", columnNames ="registration_number")
        },
        indexes = {
                @Index(name="idx_vehicle_status", columnList = "status")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(name="registration_number, nullable= false, length=50")
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false, length = 30)
    private VehicleType vehicleType;

    @Column(length = 50)
    private String manufacturer;

    @Column(length = 50)
    private String model;


    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private VehicleStatus status;

    private LocalDate insuranceExpiryDate;
    private LocalDate permitExpiryDate;

    @OneToMany(
            mappedBy = "vehicle",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<VehicleDocument> documents;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @PrePersist
    public void onCreate(){
        this.createdAt= LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        if(this.status== null){
            this.status=VehicleStatus.AVAILABLE;
        }
        }



        @PreUpdate
        public void onUpdate(){
        this.updatedAt=LocalDateTime.now();
        }
    }

