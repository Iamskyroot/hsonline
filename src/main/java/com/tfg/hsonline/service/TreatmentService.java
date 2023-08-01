package com.tfg.hsonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Treatment;

@Service
public interface TreatmentService {
    
    //save treatment
    Treatment saveTreatment(Treatment treatment);
    //get all treatments
    List<Treatment> getAllTreatments();
    //get treatment by ID
    Treatment getTreatment(int id);
    //update treatment by ID
    Treatment updateTreatment(int id, Treatment newTreatment);
    //delete treatment by ID
    String deleteTreatment(int id);

}
