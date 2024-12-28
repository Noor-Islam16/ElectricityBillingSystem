package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.model.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByConsumerId(Long consumerId);
}
