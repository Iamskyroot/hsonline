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

import com.tfg.hsonline.model.Treatment;
import com.tfg.hsonline.service.TreatmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin()
@RequestMapping("/treatments")
public class TreatmentController {
    
    //dependency injection from TreatmentService.java
    @Autowired
    private TreatmentService treatmentService;

    //save treatment
    @PostMapping("/save")
    public Treatment save(@RequestBody Treatment treatment){
        return treatmentService.saveTreatment(treatment);
    }

    //get all treatment
    @GetMapping("/")
    public List<Treatment> getAll(){
        return treatmentService.getAllTreatments();
    }

    //get treatment by ID
    @GetMapping("/{id}")
    public Treatment get(@PathVariable int id){
        return treatmentService.getTreatment(id);
    }

    //update treatment by ID
    @PutMapping
    public Treatment update(@PathVariable int id, @RequestBody Treatment newTreatment){
        return treatmentService.updateTreatment(id, newTreatment);
    }

    //delete treatment by ID
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return treatmentService.deleteTreatment(id);
    }

}
