package com.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.billing.model.Transaction;
import com.billing.model.Bill;
import com.billing.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/bill/{billId}")
    public Bill getBillDetails(@PathVariable Long billId) {
        return paymentService.getBillById(billId);
    }

    @PostMapping("/process")
    public Transaction processPayment(@RequestParam Long billId,
                                      @RequestParam double amountPaid,
                                      @RequestParam String paymentMethod) {
        return paymentService.processPayment(billId, amountPaid, paymentMethod);
    }
}
