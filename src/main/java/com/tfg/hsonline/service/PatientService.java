package com.tfg.hsonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Patient;
@Service
public interface PatientService {
    
    //save patient to db
    Patient savePatient(Patient patient);
    //get all patients
    List<Patient> getAllPatients();
    //get patient by id
    Patient getPatient(long id);
    //update patient by id
    Patient updatePatient(long id, Patient patient);
    //delete patient by id
    String deletePatient(long id);

}
