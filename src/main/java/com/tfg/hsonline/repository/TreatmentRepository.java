package com.tfg.hsonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.hsonline.model.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    
}
