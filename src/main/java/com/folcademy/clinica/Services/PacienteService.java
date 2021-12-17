package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.BadRequestException;
import com.folcademy.clinica.Exceptions.NotFoundException;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Dtos.PacienteDto;
import com.folcademy.clinica.Model.Dtos.PacienteEnteroDto;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Model.Entities.Persona;
import com.folcademy.clinica.Model.Mappers.PacienteMapper;
import com.folcademy.clinica.Model.Repositories.PacienteRepository;
import com.folcademy.clinica.Model.Repositories.PersonaRepository;
import com.folcademy.clinica.Services.Interfaces.IPacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PacienteService implements IPacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final PersonaRepository personaRepository;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper, PersonaRepository personaRepository) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
        this.personaRepository = personaRepository;
    }

    @Override
    public List<PacienteEnteroDto> findAllPacientes() {
        List<PacienteEnteroDto> pacientes = new ArrayList<>();
        List<Paciente> pacientesEntities = (List<Paciente>) pacienteRepository.findAll();
        if (pacientesEntities.isEmpty())
            throw new NotFoundException("No se encontraron pacientes");

        for (Paciente pacienteEntity : pacientesEntities){
            PacienteEnteroDto dto = pacienteMapper.entityToEnteroDto(pacienteEntity);
            dto.setPersona(pacienteEntity.getPersona());
            pacientes.add(dto);
        }

        return pacientes;


    }

    @Override
    public PacienteEnteroDto findPacienteById(Integer id) {
        if (!pacienteRepository.existsById(id))
            throw new NotFoundException("No existe el paciente");
        Paciente pacienteEntity = pacienteRepository.findById(id).get();
        PacienteEnteroDto pacienteEnteroDto = pacienteMapper.entityToEnteroDto(pacienteEntity);
        pacienteEnteroDto.setPersona(pacienteEntity.getPersona());
        return pacienteEnteroDto;
    }

    public PacienteEnteroDto save(PacienteDto paciente) {
        paciente.setId(null);
        Paciente pacienteEntity = pacienteMapper.dtoToEntity(paciente);
        Persona persona = personaRepository.findById(paciente.getId()).get();
        pacienteEntity.setPersona(persona);
        pacienteRepository.save(pacienteEntity);
        PacienteEnteroDto pacienteEnteroDto = pacienteMapper.entityToEnteroDto(pacienteEntity);
        return pacienteEnteroDto;
    }

    public PacienteEnteroDto edit(Integer idPaciente, PacienteDto dto) {
        if (!pacienteRepository.existsById(idPaciente))
            throw new NotFoundException("No existe el paciente");
        Paciente pacienteEntity = pacienteRepository.findById(idPaciente).get();
        pacienteRepository.save(pacienteEntity);
        PacienteEnteroDto pacienteEnteroDto = pacienteMapper.entityToEnteroDto(pacienteEntity);
        pacienteEnteroDto.setPersona(pacienteEntity.getPersona());
        return pacienteEnteroDto;





    }

    public PacienteEnteroDto delete(Integer id) {
        if (!pacienteRepository.existsById(id))
            throw new NotFoundException("No existe el paciente");
        Paciente pacienteEntity = pacienteRepository.findById(id).get();
        PacienteEnteroDto pacienteEnteroDto = pacienteMapper.entityToEnteroDto(pacienteEntity);
        pacienteEnteroDto.setPersona(pacienteEntity.getPersona());
        pacienteRepository.deleteById(id);
        return pacienteEnteroDto;
    }

    public Page<PacienteEnteroDto> findAllByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return pacienteRepository.findAll(pageable).map(pacienteMapper::entityToEnteroDto);
    }
}
