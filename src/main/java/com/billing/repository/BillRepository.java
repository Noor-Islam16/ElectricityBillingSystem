package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.model.Bill;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByConsumerId(Long consumerId);
}
