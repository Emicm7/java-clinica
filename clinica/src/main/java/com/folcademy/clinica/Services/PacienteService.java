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
    public List<Paciente> findPacienteById(Integer id) {
        List<Paciente> lista = new ArrayList<>();
        Paciente paciente = pacienteRepository.findById(id).get();
        lista.add(paciente);
        return lista;
    }
}
