package com.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.billing.model.Bill;
import com.billing.repository.BillRepository;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getBillsByConsumerId(Long consumerId) {
        return billRepository.findByConsumerId(consumerId);
    }

    public Bill saveBill(Bill bill) {  // <-- Add this method
        return billRepository.save(bill);
    }

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
            .orElseThrow(() -> new RuntimeException("Bill not found with ID: " + billId));
    }
}
