package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPacienteService {

    Page<Paciente> findAllByPage(Integer pageNumber, Integer pageSize);
    PacienteEnteroDto findPacienteById(Integer id);
    PacienteEnteroDto save(PacienteDto paciente);
    PacienteEnteroDto edit(Integer idPaciente, PacienteDto dto);
    PacienteEnteroDto delete(Integer id);


}
