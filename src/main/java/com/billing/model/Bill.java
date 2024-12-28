package com.billing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate; // Import LocalDate for date handling

@Data
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Long consumerId;
    private Double dueAmount;
    private Double payableAmount;

    private LocalDate billDate; // Add this field
    private LocalDate dueDate; // Change this to LocalDate instead of String

    private String status;
}
