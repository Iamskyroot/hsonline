package com.tfg.hsonline.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.hsonline.exeption.EntityNotFoundException;
import com.tfg.hsonline.model.Patient;
import com.tfg.hsonline.repository.PatientRepository;
import com.tfg.hsonline.service.PatientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
    //global message for data not found
    private static final String PATIENT_NOT_FOUND = "Paciente con ID = %d no encontrado";
    //dependency injection from PatientService
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        // return patients.stream().collect(Collectors.toList());
        return patients;
    }

    @Override
    public Patient getPatient(long id) {
        Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PATIENT_NOT_FOUND, id)));
        return patient;
    }

    @Override
    public String deletePatient(long id) {
        Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PATIENT_NOT_FOUND, id)));
        patientRepository.delete(patient);
        return "Paciente con ID = "+id+" eliminado!";
    }

    @Override
    public Patient updatePatient(long id, Patient newPatient) {
        Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PATIENT_NOT_FOUND, id)));
        patient = patientRepository.save(newPatient);
        return patient;
    }

    
    

}
