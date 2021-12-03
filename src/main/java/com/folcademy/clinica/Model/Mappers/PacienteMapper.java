package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import org.springframework.stereotype.Component;

import java.awt.geom.Path2D;
import java.util.Optional;

@Component
public class PacienteMapper {
    public PacienteDto entityToDto(Paciente entity) {
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new PacienteDto(
                                ent.getIdpaciente(),
                                ent.getDni(),
                                ent.getNombre(),
                                ent.getApellido(),
                                ent.getTelefono()
                        )
                )
                .orElse(new PacienteDto());

    }

    public Paciente dtoToEntity(PacienteDto dto) {
        Paciente entity = new Paciente();
        entity.setIdpaciente(dto.getId());
        entity.setDni(dto.getDni());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }

    public PacienteEnteroDto entityToEnteroDto(Paciente entity) {
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new PacienteEnteroDto(
                                ent.getIdpaciente(),
                                ent.getDni(),
                                ent.getNombre(),
                                ent.getApellido(),
                                ent.getTelefono()
                        )
                )
                .orElse(new PacienteEnteroDto());
    }

    public Paciente enteroDtoToEntity(PacienteEnteroDto dto) {
        Paciente entity = new Paciente();
        entity.setIdpaciente(dto.getIdpaciente());
        entity.setDni(dto.getDni());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }


}
