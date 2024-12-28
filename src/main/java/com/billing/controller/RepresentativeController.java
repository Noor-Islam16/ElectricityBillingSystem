package com.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.billing.model.Representative;
import com.billing.service.RepresentativeService;

@RestController
@RequestMapping("/api/representatives")
@CrossOrigin(origins = "http://localhost:4200")
public class RepresentativeController {

    @Autowired
    private RepresentativeService representativeService;

    // Register a new representative
    @PostMapping("/register")
    public Representative registerRepresentative(@RequestBody Representative representative) {
        return representativeService.registerRepresentative(representative);
    }

    // Get representative details by userId
    @GetMapping("/{userId}")
    public Representative getRepresentativeByUserId(@PathVariable String userId) {
        return representativeService.findByUserId(userId);
    }

    // Update representative details
    @PutMapping("/{id}")
    public Representative updateRepresentative(
            @PathVariable Long id,
            @RequestBody Representative updatedRep) {
        return representativeService.updateRepresentative(id, updatedRep);
    }
}
