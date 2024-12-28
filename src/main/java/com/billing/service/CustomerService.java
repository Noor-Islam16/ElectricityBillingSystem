package com.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.model.Customer;
import com.billing.repository.CustomerRepository;

import java.util.Optional;  // Import this for Optional

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerByUserId(String userId) {
        // Use Optional to handle null values safely
        Optional<Customer> optionalCustomer = customerRepository.findByUserId(userId);
        return optionalCustomer.orElse(null); // Return null if user is not found
    }
}
