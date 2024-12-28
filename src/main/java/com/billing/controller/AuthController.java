package com.billing.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.billing.dto.LoginDTO;
import com.billing.model.Customer;
import com.billing.repository.CustomerRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
        Optional<Customer> customer = customerRepository.findByUserId(loginDTO.getUserId());
        Map<String, Object> response = new HashMap<>();

        if (customer.isPresent() && customer.get().getPassword().equals(loginDTO.getPassword())) {
            response.put("status", "success");
            response.put("userId", customer.get().getUserId());
            response.put("customerName", customer.get().getCustomerName());
            response.put("customerId", customer.get().getConsumerId());
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }
}