package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MedicoMapper {
    public MedicoDto entityToDto(Medico entity) {
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new MedicoDto(
                                ent.getIdmedico(),
                                ent.getNombre(),
                                ent.getApellido(),
                                ent.getProfesion(),
                                ent.getConsulta(),
                                ent.getTelefono()
                        )
                )
                .orElse(new MedicoDto());

    }

    public Medico dtoToEntity(MedicoDto dto) {
        Medico entity = new Medico();
        entity.setIdmedico(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setProfesion(dto.getProfesion());
        entity.setConsulta(dto.getConsulta());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }

    public MedicoEnteroDto entityToEnteroDto(Medico entity) {
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new MedicoEnteroDto(
                                ent.getIdmedico(),
                                ent.getNombre(),
                                ent.getApellido(),
                                ent.getProfesion(),
                                ent.getConsulta(),
                                ent.getTelefono()
                        )
                )
                .orElse(new MedicoEnteroDto());
    }

    public Medico enteroDtoToEntity(MedicoEnteroDto dto) {
        Medico entity = new Medico();
        entity.setIdmedico(dto.getIdmedico());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setProfesion(dto.getProfesion());
        entity.setConsulta(dto.getConsulta());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }

}
