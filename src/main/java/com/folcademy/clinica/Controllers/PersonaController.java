package com.folcademy.clinica.Controllers;

import com.folcademy.clinica.Model.Dtos.PersonaDto;
import com.folcademy.clinica.Model.Dtos.PersonaEnteroDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;
import com.folcademy.clinica.Services.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<PersonaEnteroDto>> findAll() {
        return ResponseEntity
                .ok()
                .body(personaService.findAllPersonas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonaEnteroDto> getOne(@PathVariable(name = "id") Integer id) {
        return ResponseEntity
                .ok()
                .body(personaService.findPersonaById(id));
    }

    @PostMapping("")
    public ResponseEntity<PersonaEnteroDto> save(@RequestBody @Validated PersonaDto persona) {
        return ResponseEntity.ok(personaService.save(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaEnteroDto> edit(@PathVariable(name = "id") int id,
                                               @RequestBody @Validated PersonaDto dto) {
        return ResponseEntity.ok(personaService.edit(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaEnteroDto> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(personaService.delete(id));


    }
}
