package com.tfg.hsonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Sickness;

@Service
public interface SicknessService {
    
    //save sickness
    Sickness saveSickness(Sickness sickness);
    //get all sicknesses
    List<Sickness> getAllSicknesses();
    //get sickness by ID
    Sickness getSickness(int id);
    //update sickness by ID
    Sickness updateSickness(int id, Sickness newSickness);
    //delete sickness
    String deleteSickness(int id);

}
