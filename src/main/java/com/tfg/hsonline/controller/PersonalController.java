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

import com.tfg.hsonline.model.Personal;
import com.tfg.hsonline.service.PersonalService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin()
@RequestMapping("/personal")
public class PersonalController {

    //dependency injection from PersonalService.java
    @Autowired
    private PersonalService personalService;

    //save personal
    @PostMapping("/save")
    public Personal save(@RequestBody Personal personal){
        return personalService.savePersonal(personal);
    }

    //get all personal
    @GetMapping("/")
    public List<Personal> getAll(){
        return personalService.getAllPersonal();
    }

    //get personal by ID
    @GetMapping("/{id}")
    public Personal get(@PathVariable int id){
        return personalService.getPersonal(id);
    }

    //update personal by ID
    @PutMapping("/update/{id}")
    public Personal update(@PathVariable int id, Personal newPersonal){
        return personalService.updatePersonal(id, newPersonal);
    }

    //delete personal by ID
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return personalService.deletePersonal(id);
    }
    
}
