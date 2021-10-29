package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Entities.Paciente;

import java.util.List;

public interface IPacienteService {

    List<Paciente> findAllPacientes();
    Paciente findPacienteById(Integer id);


}
