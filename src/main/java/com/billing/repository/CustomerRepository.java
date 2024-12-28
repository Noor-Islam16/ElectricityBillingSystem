package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.model.Customer;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find Customer by User ID
    Optional<Customer> findByUserId(String userId);
}
