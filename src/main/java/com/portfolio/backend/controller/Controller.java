/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santi
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired IPersonaService IPersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return IPersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
        return "Persona Creada";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        IPersonaService.deletePersona(id);
        return "Persona Borrada";
    }
    
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("fotoPerfil") String nuevofotoPerfil
    ){
        Persona persona = IPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setFotoPerfil(nuevofotoPerfil);
        persona.setApellido(nuevoApellido);
        IPersonaService.savePersona(persona);
        return persona;
    }
    
    
    @GetMapping("/personas/traerID")
    public Persona findPersona(Long id){
        return IPersonaService.findPersona((long )2);
    }
}
