package com.billing.service;

import com.billing.model.Complaint;
import com.billing.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    // Register Complaint
    public Complaint registerComplaint(Complaint complaint) {
        // Set the date
        complaint.setComplaintDate(LocalDate.now()); // Updated method name
        complaint.setStatus("Open");
        return complaintRepository.save(complaint);
    }
    

    // Get Complaints by Consumer ID
    public List<Complaint> getComplaintsByConsumerId(Long consumerId) {
        return complaintRepository.findByConsumerId(consumerId);
    }

    // Update Complaint Status
    public Complaint updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }

    // Get Complaint by ID (New Method)
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    // Get All Complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Get Complaints by Date
    public List<Complaint> getComplaintsByDate(String date) {
        LocalDate complaintDate = LocalDate.parse(date);
        return complaintRepository.findByComplaintDate(complaintDate);
    }

    // Get Complaints by Status
    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }
    // New Method: Filter Complaints
    public List<Complaint> filterComplaints(String status, String date, String customerName) {
        List<Complaint> allComplaints = complaintRepository.findAll();

        return allComplaints.stream()
                .filter(complaint -> (status == null || complaint.getStatus().equalsIgnoreCase(status)))
                .filter(complaint -> (date == null || complaint.getComplaintDate().toString().equals(date)))
                .filter(complaint -> (customerName == null || complaint.getContactPerson().equalsIgnoreCase(customerName)))
                .collect(Collectors.toList());
    }
}
