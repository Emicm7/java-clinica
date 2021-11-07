package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Turno;
import com.folcademy.clinica.Services.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TurnoDto>> findAll() {
        return ResponseEntity
                .ok()
                .body(turnoService.findAllTurnos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurnoDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(turnoService.findTurnoById(id));
    }

    @PostMapping("")
    public ResponseEntity<TurnoDto> save(@RequestBody @Validated Turno entity) {
        return ResponseEntity.ok(turnoService.save(entity));
    }
}
