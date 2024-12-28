package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.model.Complaint;

import java.time.LocalDate;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    // Find by Consumer ID
    List<Complaint> findByConsumerId(Long consumerId);

    // Find by Complaint Date
    List<Complaint> findByComplaintDate(LocalDate date);

    // Find by Status
    List<Complaint> findByStatus(String status);
}
