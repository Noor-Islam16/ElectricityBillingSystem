package com.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.billing.model.Bill;
import com.billing.service.BillHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/bill-history")
@CrossOrigin(origins = "http://localhost:4200")
public class BillHistoryController {

    @Autowired
    private BillHistoryService billHistoryService;

    @GetMapping("/{consumerId}")
    public List<Bill> getBillHistory(@PathVariable Long consumerId) {
        return billHistoryService.getBillHistory(consumerId);
    }
}
