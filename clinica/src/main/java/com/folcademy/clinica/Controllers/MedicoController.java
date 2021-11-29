package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Services.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PreAuthorize("hasAuthority('get')")
    @GetMapping(value = "")
    public ResponseEntity<List<MedicoDto>> findAll() {
        return ResponseEntity
                .ok()
                .body(medicoService.findAllMedicos());
    }

    @PreAuthorize("hasAuthority('get')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(medicoService.findMedicoById(id));
    }

    @PreAuthorize("hasAuthority('post')")
    @PostMapping("")
    public ResponseEntity<MedicoDto> save(@RequestBody @Validated Medico dto) {
        return ResponseEntity.ok(medicoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoEnteroDto> edit(@PathVariable(name = "id") int id,
                                                @RequestBody @Validated MedicoEnteroDto dto) {
        return ResponseEntity.ok(medicoService.edit(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoDto> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(medicoService.delete(id));


    }
}
