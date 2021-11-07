package com.folcademy.clinica.Services;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Turno;
import com.folcademy.clinica.Model.Mappers.TurnoMapper;
import com.folcademy.clinica.Model.Repositories.TurnoRepository;
import com.folcademy.clinica.Services.Interfaces.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TurnoService implements ITurnoService {
    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;


    public TurnoService(TurnoRepository turnoRepository, TurnoMapper turnoMapper) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
    }

    @Override
    public List<TurnoDto> findAllTurnos() {
        List<TurnoDto> turnos=new ArrayList<>();
        List<Turno> turnosEntities= (List<Turno>) turnoRepository.findAll();

        for (Turno turnoEntity : turnosEntities){
            turnos.add(turnoMapper.entityToDto(turnoEntity));
        }

        return turnos;


    }

    @Override
    public TurnoDto findTurnoById(Integer id) {
        Turno turnoEntity = turnoRepository.findById(id).orElse(null);
        TurnoDto turnoDto = turnoMapper.entityToDto(turnoEntity);
        return turnoDto;
    }

    @Override
    public TurnoDto save(Turno turno) {
        if (Objects.isNull(turno.getFecha())
                || Objects.isNull(turno.getHora())
                || Objects.isNull(turno.getAtendido()))
            return null;
        turno.setIdturno(null);
        turnoRepository.save(turno);
        TurnoDto turnoDto = turnoMapper.entityToDto(turno);
        return turnoDto;
    }
}
