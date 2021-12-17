package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;

import java.util.List;

public interface IPacienteService {

    List<PacienteEnteroDto> findAllPacientes();
    PacienteEnteroDto findPacienteById(Integer id);
    PacienteEnteroDto save(PacienteDto paciente);
    PacienteEnteroDto edit(Integer idPaciente, PacienteDto dto);
    PacienteEnteroDto delete(Integer id);


}
