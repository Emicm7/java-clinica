package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Services.PacienteService;
import org.springframework.data.domain.Page;
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


    @GetMapping(value = "/page")
    public ResponseEntity<Page<Paciente>> findAllByPage(
            @RequestParam(name = "pageNumber",defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = "2") Integer pageSize
    ) {
        return ResponseEntity
                .ok()
                .body(pacienteService.findAllByPage(pageNumber,pageSize));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteEnteroDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(pacienteService.findPacienteById(id));
    }

    @PostMapping("")
    public ResponseEntity<PacienteEnteroDto> save(@RequestBody @Validated PacienteDto entity) {
        return ResponseEntity.ok(pacienteService.save(entity));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEnteroDto> edit(@PathVariable(name = "id") int id,
                                                  @RequestBody @Validated PacienteDto dto) {
        return ResponseEntity.ok(pacienteService.edit(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteEnteroDto> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(pacienteService.delete(id));


    }
}
