package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Services.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(value = "/page")
    public ResponseEntity<Page<MedicoEnteroDto>> findAllByPage(
            @RequestParam(name = "pageNumber",defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = "2") Integer pageSize
    ) {
        return ResponseEntity
                .ok()
                .body(medicoService.findAllByPage(pageNumber,pageSize));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoEnteroDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(medicoService.findMedicoById(id));
    }


    @PostMapping("")
    public ResponseEntity<MedicoEnteroDto> save(@RequestBody @Validated MedicoDto dto) {
        return ResponseEntity.ok(medicoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoEnteroDto> edit(@PathVariable(name = "id") int id,
                                                @RequestBody @Validated MedicoDto dto) {
        return ResponseEntity.ok(medicoService.edit(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoEnteroDto> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(medicoService.delete(id));


    }
}
