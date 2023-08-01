package com.tfg.hsonline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.hsonline.model.Sickness;
import com.tfg.hsonline.repository.SicknessRepository;
import com.tfg.hsonline.service.SicknessService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SicknessServiceImpl implements SicknessService {

    //global message for data not found
    public static final String SICKNESS_NOT_FOUND = "Enfermedad con ID = %d no encontrado!";
    //dependency injection from SicknessRepository.java
    @Autowired
    private SicknessRepository sicknessRepository;

    @Override
    public String deleteSickness(int id) {
        sicknessRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(SICKNESS_NOT_FOUND, id)));
        sicknessRepository.deleteById(id);
        return "Enfermedad "+id+" eliminado!";
    }

    @Override
    public List<Sickness> getAllSicknesses() {
        List<Sickness> sicknesses = sicknessRepository.findAll();
        return sicknesses;
    }

    @Override
    public Sickness getSickness(int id) {
        Sickness sickness = sicknessRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(SICKNESS_NOT_FOUND, id)));
        return sickness;
    }

    @Override
    public Sickness saveSickness(Sickness sickness) {
        return sicknessRepository.save(sickness);
    }

    @Override
    public Sickness updateSickness(int id, Sickness newSickness) {
       sicknessRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(SICKNESS_NOT_FOUND, id)));
        Sickness sickness = sicknessRepository.save(newSickness);
        return sickness;
    }
    
    
    
}
