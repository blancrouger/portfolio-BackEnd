/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santi
 */
@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository IPersonaRepository;

    @Override
    public List<Persona> getPersona() {
        return IPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        IPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return IPersonaRepository.findById(id).orElse(null);
    }
    
}
