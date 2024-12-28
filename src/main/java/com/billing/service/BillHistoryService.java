package com.billing.service;

import com.billing.model.Bill;
import com.billing.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillHistoryService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getBillHistory(Long consumerId) {
        LocalDate currentDate = LocalDate.now();
        LocalDate fiveMonthsAgo = currentDate.minusMonths(5);

        // Fetch bills and filter based on billDate
        return billRepository.findByConsumerId(consumerId)
                .stream()
                .filter(bill -> bill.getBillDate() != null && // Ensure date is not null
                        !bill.getBillDate().isBefore(fiveMonthsAgo) && // After 5 months ago
                        !bill.getBillDate().isAfter(currentDate)) // Before today
                .collect(Collectors.toList());
    }
}
