package com.billing.controller;

import com.billing.model.Complaint;
import com.billing.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular access
public class ComplaintStatusController {

    @Autowired
    private ComplaintService complaintService;

    // Fetch complaint details by ID
    @GetMapping("/status/{id}")
    public ResponseEntity<?> getComplaintStatus(@PathVariable Long id) {
        try {
            Complaint complaint = complaintService.getComplaintById(id);
            return ResponseEntity.ok(complaint);
        } catch (RuntimeException ex) {
            // Handle errors gracefully
            return ResponseEntity.status(404).body("Complaint not found with ID: " + id);
        }
    }
}
