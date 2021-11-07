package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Turno;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TurnoMapper {
    public TurnoDto entityToDto(Turno entity) {
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new TurnoDto(
                                ent.getIdturno(),
                                ent.getFecha(),
                                ent.getHora(),
                                ent.getAtendido()
                        )
                )
                .orElse(new TurnoDto());

    }

    public Turno dtoToEntity(TurnoDto dto) {
        Turno entity = new Turno();
        entity.setIdturno(dto.getId());
        entity.setFecha(dto.getFecha());
        entity.setHora(dto.getHora());
        entity.setAtendido(dto.getAtendido());
        return entity;
    }

}
