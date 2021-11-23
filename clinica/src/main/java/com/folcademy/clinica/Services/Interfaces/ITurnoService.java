package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;
import com.folcademy.clinica.Model.Entities.Turno;

import java.util.List;

public interface ITurnoService {

    List<TurnoEnteroDto> findAllTurnos();
    TurnoEnteroDto findTurnoById(Integer id);
    TurnoEnteroDto save(TurnoDto turno);
    TurnoEnteroDto edit(Integer idTurno, TurnoDto dto);
    TurnoEnteroDto delete(Integer id);
}
