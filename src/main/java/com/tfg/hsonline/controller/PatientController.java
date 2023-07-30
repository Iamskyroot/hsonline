package com.tfg.hsonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.hsonline.model.Patient;
import com.tfg.hsonline.service.PatientService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin()
@RequestMapping("/patients")
public class PatientController {

    //dependency injection from PatientService.java
    @Autowired
    private PatientService patientService;

    //save patient
    @PostMapping("/save")
    public Patient save(@RequestBody Patient newPatient){
        return patientService.savePatient(newPatient);
    }

    //get all patients
    @GetMapping("/")
    public List<Patient> getAll(){
        return patientService.getAllPatients();
    }

    //get a patient by id
    @GetMapping("/{id}")
    public Patient get(@PathVariable long id){
        return patientService.getPatient(id);
    }

    //update patient by id
    @PutMapping("/update/{id}")
    public Patient update(@PathVariable long id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    //delete patient by id
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        return patientService.deletePatient(id);
    }

}
