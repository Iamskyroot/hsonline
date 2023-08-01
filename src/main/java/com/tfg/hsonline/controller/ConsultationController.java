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

import com.tfg.hsonline.model.Consultation;
import com.tfg.hsonline.service.ConsultationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin()
@RequestMapping("/consultations")
public class ConsultationController {

    //dependency injection from ConsultationService.java
    @Autowired
    private ConsultationService consultationService;

    //save consultation
    @PostMapping("/save")
    public Consultation save(@RequestBody Consultation newConsultation){
        return consultationService.saveConsultation(newConsultation);
    }

    //get all consultations
    @GetMapping("/")
    public List<Consultation> getAll(){
        return consultationService.getAllConsultations();
    }

    //get consultation by ID
    @GetMapping("/{id}")
    public Consultation get(@PathVariable long id){
        return consultationService.getConsultation(id);
    }

    //update consultation by ID
    @PutMapping("/update/{id}")
    public Consultation update(@PathVariable long id, @RequestBody Consultation newConsultation){
        return consultationService.updateConsultation(id, newConsultation);
    }

    //delete consultation by ID
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        return consultationService.deleteConsultation(id);
    }
    
}
