package com.billing.controller;

import com.billing.model.Complaint;
import com.billing.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular access
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Register Complaint
    @PostMapping("/register")
    public Complaint registerComplaint(@RequestBody Complaint complaint) {
        return complaintService.registerComplaint(complaint);
    }

    // View Complaints by Consumer ID
    @GetMapping("/view")
    public List<Complaint> getComplaints(@RequestParam Long consumerId) {
        return complaintService.getComplaintsByConsumerId(consumerId);
    }

    // Update Complaint Status
    @PutMapping("/update-status/{id}")
    public Complaint updateComplaintStatus(@PathVariable Long id, @RequestParam String status) {
        return complaintService.updateComplaintStatus(id, status);
    }

    // --- New Methods for Task 7 ---

    // View All Complaints
    @GetMapping("/all")
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // Filter Complaints by Date
    @GetMapping("/date")
    public List<Complaint> getComplaintsByDate(@RequestParam String date) {
        return complaintService.getComplaintsByDate(date);
    }

    // Filter Complaints by Status
    @GetMapping("/status")
    public List<Complaint> getComplaintsByStatus(@RequestParam String status) {
        return complaintService.getComplaintsByStatus(status);
    }
    @GetMapping("/filter")
public List<Complaint> filterComplaints(
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String customerName) {
    return complaintService.filterComplaints(status, date, customerName);
}
}
