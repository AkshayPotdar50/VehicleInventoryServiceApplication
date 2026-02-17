package com.company.logistic.inventory.vehicleInventoryServiceApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="vehicle_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="vehicle_id", nullable = false,
    foreignKey = @ForeignKey(name="fk_vehicle_document_vehicle"))
    private Vehicle vehicle;

    @Column(name="document_type", nullable = false, length = 30)
    private String documentType;

    @Column(name="document_number", length = 50)
    private String documentNumber;

    private LocalDate expiryDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;


    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
    }


}
