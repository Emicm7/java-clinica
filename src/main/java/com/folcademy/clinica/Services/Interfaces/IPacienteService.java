package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;

import java.util.List;

public interface IPacienteService {

    List<PacienteDto> findAllPacientes();
    PacienteDto findPacienteById(Integer id);
    PacienteDto save(Paciente paciente);
    PacienteEnteroDto edit(Integer idPaciente, PacienteEnteroDto dto);
    PacienteDto delete(Integer id);


}
