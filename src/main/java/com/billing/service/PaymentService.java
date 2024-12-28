package com.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.billing.model.Transaction;
import com.billing.model.Bill;
import com.billing.repository.TransactionRepository;
import com.billing.repository.BillRepository;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BillRepository billRepository;

    public Bill getBillById(Long billId) {
        Optional<Bill> bill = billRepository.findById(billId);
        return bill.orElse(null);
    }

    public Transaction processPayment(Long billId, double amountPaid, String paymentMethod) {
        Bill bill = getBillById(billId);

        if (bill == null || amountPaid < bill.getPayableAmount()) {
            throw new IllegalArgumentException("Invalid payment details.");
        }

        // Mark bill as paid
        bill.setStatus("Paid");
        billRepository.save(bill);

        // Record the transaction
        Transaction transaction = new Transaction(bill.getConsumerId(), billId, amountPaid, paymentMethod);
        return transactionRepository.save(transaction);
    }
}
