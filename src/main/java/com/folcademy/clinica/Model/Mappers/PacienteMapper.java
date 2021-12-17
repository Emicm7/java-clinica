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
        PacienteDto dto = new PacienteDto();
        dto.setId(entity.getIdpaciente());
        return  dto;
    }

    public Paciente dtoToEntity(PacienteDto dto) {
        Paciente entity = new Paciente();
        entity.setIdpaciente(dto.getId());
        return entity;
    }

    public PacienteEnteroDto entityToEnteroDto(Paciente entity) {
        PacienteEnteroDto dto = new PacienteEnteroDto();
        dto.setIdpaciente(entity.getIdpaciente());
        return dto;
    }

    public Paciente enteroDtoToEntity(PacienteEnteroDto dto) {
        Paciente entity = new Paciente();
        entity.setIdpaciente(dto.getIdpaciente());
        return entity;
    }


}
