package com.tfg.hsonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.hsonline.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    
}
