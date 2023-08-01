package com.tfg.hsonline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Treatment;
import com.tfg.hsonline.repository.TreatmentRepository;
import com.tfg.hsonline.service.TreatmentService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TreatmentServiceImpl implements TreatmentService {
    
    //global message for data not found
    public static final String TREATMENT_NOT_FOUND = "Tratamiento con ID = %d no encontrado!";
    //dependency injection from TreatmentRepository.java
    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public String deleteTreatment(int id) {
        Treatment treatment = treatmentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(TREATMENT_NOT_FOUND, id)));
        treatmentRepository.delete(treatment);
        return "Tratamiento "+id+" eliminado!";
    }

    @Override
    public Treatment getTreatment(int id) {
        Treatment treatment = treatmentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(TREATMENT_NOT_FOUND, id)));
        return treatment;
    }

    @Override
    public List<Treatment> getAllTreatments() {
        List<Treatment> treatments = treatmentRepository.findAll();
        return treatments;
    }

    @Override
    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    @Override
    public Treatment updateTreatment(int id, Treatment newTreatment) {
        treatmentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(TREATMENT_NOT_FOUND, id)));
        Treatment treatment = treatmentRepository.save(newTreatment);
        return treatment;
    }

    

}
