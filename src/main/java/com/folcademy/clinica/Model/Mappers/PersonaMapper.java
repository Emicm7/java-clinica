package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.PersonaDto;
import com.folcademy.clinica.Model.Dtos.PersonaEnteroDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;
import com.folcademy.clinica.Model.Entities.Persona;
import com.folcademy.clinica.Model.Entities.Turno;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    public PersonaDto entityToDto(Persona entity) {
        PersonaDto persona = new PersonaDto();
        persona.setId(entity.getIdpersona());
        persona.setNombre(entity.getNombre());
        persona.setApellido(entity.getApellido());
        persona.setDni(entity.getDni());
        persona.setDireccion(entity.getDireccion());
        persona.setTelefono(entity.getTelefono());
        return persona;

    }

    public Persona dtoToEntity(PersonaDto dto) {
        Persona entity = new Persona();
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setDni(dto.getDni());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }

    public PersonaEnteroDto entityToEnteroDto(Persona entity) {
        PersonaEnteroDto persona = new PersonaEnteroDto();
        persona.setId(entity.getIdpersona());
        persona.setNombre(entity.getNombre());
        persona.setApellido(entity.getApellido());
        persona.setDni(entity.getDni());
        persona.setDireccion(entity.getDireccion());
        persona.setTelefono(entity.getTelefono());
        return persona;

    }

    public Persona enteroDtoToEntity(PersonaEnteroDto dto) {
        Persona entity = new Persona();
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setDni(dto.getDni());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }
}
