package com.billing.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "representatives")
public class Representative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;       // Representative's name
    private String email;      // Email ID for communication
    private String mobile;     // Contact number
    private String userId;     // Login user ID
    private String password;   // Password (ensure hashing for security)

    private String role;       // Role (e.g., Support, Manager)
}
