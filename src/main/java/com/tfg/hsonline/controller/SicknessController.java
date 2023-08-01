package com.tfg.hsonline.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.hsonline.model.Sickness;
import com.tfg.hsonline.service.SicknessService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin()
@RequestMapping("/sicknesses")
public class SicknessController {

    //dependency injection from SicknessService.java
    private SicknessService sicknessService;

    //save sickness
    @PostMapping("/save")
    public Sickness save(@RequestBody Sickness sickness){
        return sicknessService.saveSickness(sickness);
    }

    //get all sickness
    @GetMapping("/")
    public List<Sickness> getAll(){
        return sicknessService.getAllSicknesses();
    }

    //get sickness by ID
    @GetMapping("/{id}")
    public Sickness get(@PathVariable int id){
        return sicknessService.getSickness(id);
    }

    //update sickness by ID
    @PutMapping("/update/{id}")
    public Sickness update(@PathVariable int id, @RequestBody Sickness newSickness){
        return sicknessService.updateSickness(id, newSickness);
    }

    //delete sickness
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return sicknessService.deleteSickness(id);
    }
    
}
