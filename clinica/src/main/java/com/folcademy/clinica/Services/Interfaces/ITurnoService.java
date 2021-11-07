package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Entities.Turno;

import java.util.List;

public interface ITurnoService {

    List<TurnoDto> findAllTurnos();
    TurnoDto findTurnoById(Integer id);
    TurnoDto save(Turno turno);
}
