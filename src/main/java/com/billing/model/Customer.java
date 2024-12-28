package com.billing.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "consumer_id")
    private Long consumerId;

    @Column(name = "bill_number")
    private Integer billNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status = "Active";
}
