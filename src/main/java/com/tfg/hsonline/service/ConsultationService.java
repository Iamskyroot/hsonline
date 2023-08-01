package com.tfg.hsonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Consultation;

@Service
public interface ConsultationService {
    
    //save consultation
    Consultation saveConsultation(Consultation consultation);
    //get all consultation
    List<Consultation> getAllConsultations();
    //get consultation by ID
    Consultation getConsultation(long id);
    //update consultation
    Consultation updateConsultation(long id, Consultation newConsultation);
    //delete consultation by ID
    String deleteConsultation(long id);

}
