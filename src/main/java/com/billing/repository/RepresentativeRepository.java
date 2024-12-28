package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.model.Representative;

public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
    Representative findByUserId(String userId);
}
