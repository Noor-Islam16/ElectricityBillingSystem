package com.billing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    private Long consumerId;
    private String category;
    private String description;
    private String status;
    private String contactPerson;

    // Add complaintDate field
    private LocalDate complaintDate; // Field should match the method name

    // Getter and Setter for complaintDate
    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }
}
