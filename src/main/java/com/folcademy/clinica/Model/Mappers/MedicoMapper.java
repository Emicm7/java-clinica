package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MedicoMapper {
    public MedicoDto entityToDto(Medico entity) {
        MedicoDto dto = new MedicoDto();
        dto.setId(entity.getIdmedico());
        dto.setConsulta(entity.getConsulta());
        dto.setProfesion(entity.getProfesion());
        return  dto;

    }

    public Medico dtoToEntity(MedicoDto dto) {
        Medico entity = new Medico();
        entity.setIdmedico(dto.getId());
        entity.setProfesion(dto.getProfesion());
        entity.setConsulta(dto.getConsulta());
        return entity;
    }

    public MedicoEnteroDto entityToEnteroDto(Medico entity) {
        MedicoEnteroDto dto = new MedicoEnteroDto();
        dto.setIdmedico(entity.getIdmedico());
        dto.setProfesion(entity.getProfesion());
        dto.setConsulta(entity.getConsulta());
        return dto;
    }

    public Medico enteroDtoToEntity(MedicoEnteroDto dto) {
        Medico entity = new Medico();
        entity.setIdmedico(dto.getIdmedico());
        entity.setProfesion(dto.getProfesion());
        entity.setConsulta(dto.getConsulta());
        return entity;
    }
}
