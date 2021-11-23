package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<PacienteDto>> findAll() {
        return ResponseEntity
                .ok()
                .body(pacienteService.findAllPacientes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(pacienteService.findPacienteById(id));
    }

    @PostMapping("")
    public ResponseEntity<PacienteDto> save(@RequestBody @Validated Paciente entity) {
        return ResponseEntity.ok(pacienteService.save(entity));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEnteroDto> edit(@PathVariable(name = "id") int id,
                                                  @RequestBody @Validated PacienteEnteroDto dto) {
        return ResponseEntity.ok(pacienteService.edit(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteDto> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(pacienteService.delete(id));


    }
}
