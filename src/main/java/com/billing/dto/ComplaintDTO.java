package com.billing.dto;

import lombok.Data;

@Data
public class ComplaintDTO {
    private String complaintType;
    private String category;
    private String description;
    private String contactPerson;
}
