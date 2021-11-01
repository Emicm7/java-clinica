package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping(value = "")
    public ResponseEntity<List<Medico>> findAll() {
        return ResponseEntity
                .ok()
                .body(medicoService.findAllMedicos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Medico> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(medicoService.findMedicoById(id));
    }
}
