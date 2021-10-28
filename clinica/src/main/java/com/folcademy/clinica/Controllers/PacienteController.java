package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @GetMapping(value = "")
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity
                .ok()
                .body(
                        pacienteService.findAllPacientes())
                ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Paciente>> findAll(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(
                        pacienteService.findPacienteById(id))
                ;
    }
}
