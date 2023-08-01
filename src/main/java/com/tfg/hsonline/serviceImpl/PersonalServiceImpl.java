package com.tfg.hsonline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Personal;
import com.tfg.hsonline.repository.PersonalRepository;
import com.tfg.hsonline.service.PersonalService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonalServiceImpl implements PersonalService {

    //global message for data not found
    private static final String PERSONAL_NOT_FOUND = "Personal con ID = %d no encontrado!";
    //dependecy injection from PersonalRepository.java
    @Autowired
    private PersonalRepository personalRepository;

    @Override
    public String deletePersonal(int id) {
        Personal personal = personalRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PERSONAL_NOT_FOUND, id)));
        personalRepository.delete(personal);
        return "Personal "+id+" eliminado!";
    }

    @Override
    public List<Personal> getAllPersonal() {
        List<Personal> personalList = personalRepository.findAll();
        return personalList;
    }

    @Override
    public Personal getPersonal(int id) {
        Personal personal = personalRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PERSONAL_NOT_FOUND, id)));
        return personal;
    }

    @Override
    public Personal savePersonal(Personal newPersonal) {
        Personal personal = personalRepository.save(newPersonal);
        return personal;
    }

    @Override
    public Personal updatePersonal(int id, Personal newPersonal) {
        personalRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(PERSONAL_NOT_FOUND, id)));
        Personal personal = personalRepository.save(newPersonal);
        return personal;
    }

    

}
