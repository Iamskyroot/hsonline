package com.tfg.hsonline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.hsonline.exeption.EntityNotFoundException;
import com.tfg.hsonline.model.Consultation;
import com.tfg.hsonline.repository.ConsultationRepository;
import com.tfg.hsonline.service.ConsultationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ConsultationServiceImpl implements ConsultationService {

    //global message for data not found
    private static final String CONSULTATION_NOT_FOUND = "Consulta con ID = %d no encontrado!";
    //dependency injection from ConsultationRepository.java
    @Autowired
    private ConsultationRepository coRepository;

    @Override
    public String deleteConsultation(long id) {
        coRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(CONSULTATION_NOT_FOUND, id)));
        coRepository.deleteById(id);
        return "Consulta "+id+"eliminada!";
    }

    @Override
    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = coRepository.findAll();
        return consultations;
    }

    @Override
    public Consultation getConsultation(long id) {
        Consultation consultation = coRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(CONSULTATION_NOT_FOUND, id)));
        return consultation;
    }

    @Override
    public Consultation saveConsultation(Consultation newConsultation) {
        Consultation consultation = coRepository.save(newConsultation);
        return consultation;
    }

    @Override
    public Consultation updateConsultation(long id, Consultation newConsultation) {
        coRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(CONSULTATION_NOT_FOUND, id)));
        Consultation consultation = coRepository.save(newConsultation);
        return consultation;
    }
    
    

}
