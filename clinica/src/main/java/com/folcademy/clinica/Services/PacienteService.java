package com.folcademy.clinica.Services;

import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Model.Mappers.PacienteMapper;
import com.folcademy.clinica.Model.Repositories.PacienteRepository;
import com.folcademy.clinica.Services.Interfaces.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PacienteService implements IPacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public List<PacienteDto> findAllPacientes() {
        List<PacienteDto> pacientes = new ArrayList<>();
        List<Paciente> pacientesEntities = (List<Paciente>) pacienteRepository.findAll();

        for (Paciente pacienteEntity : pacientesEntities){
            pacientes.add(pacienteMapper.entityToDto(pacienteEntity));
        }

        return pacientes;


    }

    @Override
    public PacienteDto findPacienteById(Integer id) {
        Paciente pacienteEntity = pacienteRepository.findById(id).orElse(null);
        PacienteDto pacienteDto = pacienteMapper.entityToDto(pacienteEntity);
        return pacienteDto;
    }

    public PacienteDto save(Paciente paciente) {
        if (Objects.isNull(paciente.getNombre())
                || Objects.isNull(paciente.getTelefono())
                || Objects.isNull(paciente.getApellido()))
            return null;
        paciente.setIdpaciente(null);
        pacienteRepository.save(paciente);
        PacienteDto pacienteDto = pacienteMapper.entityToDto(paciente);
        return pacienteDto;
    }

    public PacienteEnteroDto edit(Integer idMedico, PacienteEnteroDto dto) {
        if (!pacienteRepository.existsById(idMedico))
            return null;
        dto.setIdpaciente(idMedico);
        return pacienteMapper.entityToEnteroDto(
                pacienteRepository.save(
                        pacienteMapper.enteroDtoToEntity(
                                dto
                        )
                )
        );





    }

    public boolean delete(Integer id) {
        if (!pacienteRepository.existsById(id))
            return false;
        pacienteRepository.deleteById(id);
        return true;
    }
}
