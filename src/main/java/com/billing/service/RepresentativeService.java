package com.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.billing.model.Representative;
import com.billing.repository.RepresentativeRepository;

import java.util.Optional;

@Service
public class RepresentativeService {

    @Autowired
    private RepresentativeRepository representativeRepository;

    public Representative registerRepresentative(Representative representative) {
        return representativeRepository.save(representative);
    }

    public Representative findByUserId(String userId) {
        return representativeRepository.findByUserId(userId);
    }

    public Representative updateRepresentative(Long id, Representative updatedRep) {
        Optional<Representative> existingRep = representativeRepository.findById(id);
        if (existingRep.isPresent()) {
            Representative rep = existingRep.get();
            rep.setName(updatedRep.getName());
            rep.setEmail(updatedRep.getEmail());
            rep.setMobile(updatedRep.getMobile());
            rep.setRole(updatedRep.getRole());
            return representativeRepository.save(rep);
        } else {
            throw new RuntimeException("Representative not found!");
        }
    }
}
