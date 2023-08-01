package com.tfg.hsonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Personal;

@Service
public interface PersonalService {
    
    //save personal
    Personal savePersonal(Personal newPersonal);
    //get all personal
    List<Personal> getAllPersonal();
    //get personal by ID
    Personal getPersonal(int id);
    //update personal by ID
    Personal updatePersonal(int id, Personal newPersonal);
    //delete personal by ID
    String deletePersonal(int id);

}
