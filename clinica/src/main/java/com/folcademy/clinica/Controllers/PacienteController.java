package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "")
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity
                .ok()
                .body(pacienteService.findAllPacientes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(pacienteService.findPacienteById(id));
    }
}
