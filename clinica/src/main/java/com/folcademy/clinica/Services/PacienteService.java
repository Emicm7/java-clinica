package com.folcademy.clinica.Services;

import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Model.Repositories.PacienteRepository;
import com.folcademy.clinica.Services.Interfaces.IPacienteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PacienteService implements IPacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @Override
    public List<Paciente> findAllPacientes() {

        return (List<Paciente>) pacienteRepository.findAll();


    }

    @Override
    public Paciente findPacienteById(Integer id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        return paciente;
    }
}
