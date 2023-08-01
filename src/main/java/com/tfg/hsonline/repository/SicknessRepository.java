package com.tfg.hsonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.hsonline.model.Sickness;

@Repository
public interface SicknessRepository extends JpaRepository<Sickness, Integer> {
    
}
