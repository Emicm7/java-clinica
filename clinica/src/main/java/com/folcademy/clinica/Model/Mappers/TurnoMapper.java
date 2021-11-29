package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Turno;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TurnoMapper {
    public TurnoDto entityToDto(Turno entity) {
        TurnoDto turno = new TurnoDto();
        turno.setId(entity.getIdTurno());
        turno.setFecha(entity.getFecha());
        turno.setHora(entity.getHora());
        turno.setAtendido(entity.getAtendido());
        return turno;

    }

    public Turno dtoToEntity(TurnoDto dto) {
        Turno entity = new Turno();
        entity.setFecha(dto.getFecha());
        entity.setHora(dto.getHora());
        entity.setAtendido(dto.getAtendido());
        return entity;
    }

    public TurnoEnteroDto entityToEnteroDto(Turno entity) {
        TurnoEnteroDto turno = new TurnoEnteroDto();
        turno.setIdTurno(entity.getIdTurno());
        turno.setFecha(entity.getFecha());
        turno.setHora(entity.getHora());
        turno.setAtendido(entity.getAtendido());
        return turno;

    }

    public Turno enteroDtoToEntity(TurnoEnteroDto dto) {
        Turno entity = new Turno();
        entity.setFecha(dto.getFecha());
        entity.setHora(dto.getHora());
        entity.setAtendido(dto.getAtendido());
        return entity;
    }


}
