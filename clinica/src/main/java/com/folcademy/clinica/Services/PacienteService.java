package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.BadRequestException;
import com.folcademy.clinica.Exceptions.NotFoundException;
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
        if (pacientesEntities.isEmpty())
            throw new NotFoundException("No se encontraron pacientes");

        for (Paciente pacienteEntity : pacientesEntities){
            pacientes.add(pacienteMapper.entityToDto(pacienteEntity));
        }

        return pacientes;


    }

    @Override
    public PacienteDto findPacienteById(Integer id) {
        if (!pacienteRepository.existsById(id))
            throw new NotFoundException("No existe el paciente");
        Paciente pacienteEntity = pacienteRepository.findById(id).orElse(null);
        PacienteDto pacienteDto = pacienteMapper.entityToDto(pacienteEntity);
        return pacienteDto;
    }

    public PacienteDto save(Paciente paciente) {
        paciente.setIdpaciente(null);
        if (paciente.getTelefono().isEmpty())
            throw new BadRequestException("El telefono tiene que ser obligatorio");
        pacienteRepository.save(paciente);
        PacienteDto pacienteDto = pacienteMapper.entityToDto(paciente);
        return pacienteDto;
    }

    public PacienteEnteroDto edit(Integer idPaciente, PacienteEnteroDto dto) {
        if (!pacienteRepository.existsById(idPaciente))
            throw new NotFoundException("No existe el paciente");
        dto.setIdpaciente(idPaciente);
        return pacienteMapper.entityToEnteroDto(
                pacienteRepository.save(
                        pacienteMapper.enteroDtoToEntity(
                                dto
                        )
                )
        );





    }

    public PacienteDto delete(Integer id) {
        if (!pacienteRepository.existsById(id))
            throw new NotFoundException("No existe el paciente");
        Paciente pacienteEntity = pacienteRepository.findById(id).get();
        PacienteDto pacienteDto = pacienteMapper.entityToDto(pacienteEntity);
        pacienteRepository.deleteById(id);
        return pacienteDto;
    }
}
