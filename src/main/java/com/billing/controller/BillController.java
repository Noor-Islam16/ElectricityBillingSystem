package com.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.billing.model.Bill;
import com.billing.service.BillService;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {

    @Autowired
    private BillService billService;

    // View bills by consumer ID
    @GetMapping("/view")
    public List<Bill> getBills(@RequestParam Long consumerId) {
        return billService.getBillsByConsumerId(consumerId);
    }

    // Add a new bill
    @PostMapping("/add")
    public Bill addBill(@RequestBody Bill bill) {
        return billService.saveBill(bill);
    }

    // Get bill details by ID
    @GetMapping("/bill/{billId}")
    public ResponseEntity<?> getBillDetails(@PathVariable Long billId) {
        try {
            System.out.println("Fetching bill details for ID: " + billId);
            Bill bill = billService.getBillById(billId);
            return ResponseEntity.ok(bill);
        } catch (Exception e) {
            System.err.println("Error fetching bill: " + e.getMessage());
            return ResponseEntity.status(404).body("Bill not found");
        }
    }
}