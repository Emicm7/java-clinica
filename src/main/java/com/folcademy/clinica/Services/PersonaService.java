package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.NotFoundException;
import com.folcademy.clinica.Model.Dtos.PersonaDto;
import com.folcademy.clinica.Model.Dtos.PersonaEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Model.Entities.Persona;
import com.folcademy.clinica.Model.Mappers.PersonaMapper;
import com.folcademy.clinica.Model.Repositories.MedicoRepository;
import com.folcademy.clinica.Model.Repositories.PacienteRepository;
import com.folcademy.clinica.Model.Repositories.PersonaRepository;
import com.folcademy.clinica.Services.Interfaces.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public PersonaService(PersonaRepository personaRepository, PersonaMapper personaMapper, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }


    @Override
    public List<PersonaEnteroDto> findAllPersonas() {
        List<PersonaEnteroDto> personas=new ArrayList<>();
        List<Persona> personasEntities= (List<Persona>) personaRepository.findAll();
        if (personasEntities.isEmpty())
            throw new NotFoundException("No se encontraron personas disponibles");

        for (Persona personaEntity : personasEntities){
            PersonaEnteroDto persona = personaMapper.entityToEnteroDto(personaEntity);
            persona.setPaciente(personaEntity.getPaciente());
            persona.setMedico(personaEntity.getMedico());
            personas.add(persona);
        }

        return personas;


    }

    @Override
    public PersonaEnteroDto findPersonaById(Integer id) {
        if (!personaRepository.existsById(id))
            throw new NotFoundException("No existe esta persona");
        Persona personaEntity= personaRepository.findById(id).orElse(null);
        PersonaEnteroDto personaEnteroDto = personaMapper.entityToEnteroDto(personaEntity);
        personaEnteroDto.setPaciente(personaEntity.getPaciente());
        personaEnteroDto.setMedico(personaEntity.getMedico());
        return personaEnteroDto;
    }

    @Override
    public PersonaEnteroDto save(PersonaDto persona) {
        if (!pacienteRepository.existsById(persona.getIdPaciente()))
            throw new NotFoundException("No existe el paciente");
        if (!medicoRepository.existsById(persona.getIdMedico()))
            throw new NotFoundException("No existe el medico");
        Persona personaEntity = personaMapper.dtoToEntity(persona);
        Paciente paciente = pacienteRepository.findById(persona.getIdPaciente()).get();
        Medico medico = medicoRepository.findById(persona.getIdMedico()).get();
        personaEntity.setMedico(medico);
        personaEntity.setPaciente(paciente);
        personaEntity.setIdMedico(persona.getIdMedico());
        personaEntity.setIdPaciente(persona.getIdPaciente());
        personaRepository.save(personaEntity);
        PersonaEnteroDto personaEnteroDto = personaMapper.entityToEnteroDto(personaEntity);
        personaEnteroDto.setPaciente(paciente);
        personaEnteroDto.setMedico(medico);
        return personaEnteroDto;
    }

    public PersonaEnteroDto edit(Integer idPersona, PersonaDto dto) {
        System.out.println(idPersona);
        if (!personaRepository.existsById(idPersona))
            throw new NotFoundException("No existe la persona");
        Persona personaEntity = personaRepository.getById(idPersona);
        System.out.println(personaEntity);
        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente()).get();
        Medico medico = medicoRepository.findById(dto.getIdMedico()).get();
        personaEntity.setNombre(dto.getApellido());
        personaEntity.setApellido(dto.getApellido());
        personaEntity.setDni(dto.getDni());
        personaEntity.setMedico(medico);
        personaEntity.setPaciente(paciente);
        personaEntity.setIdMedico(dto.getIdMedico());
        personaEntity.setIdPaciente(dto.getIdPaciente());
        personaRepository.save(turnoEntity);
        PersonaEnteroDto personaEnteroDto = personaMapper.entityToEnteroDto(personaEntity);
        personaEnteroDto.setPaciente(paciente);
        personaEnteroDto.setMedico(medico);
        return personaEnteroDto;
    }

    public PersonaEnteroDto delete(Integer id) {
        if (!personaRepository.existsById(id))
            throw new NotFoundException("No existe la persona");
        Persona personaEntity = personaRepository.findById(id).get();
        PersonaEnteroDto personaEnteroDto = personaMapper.entityToEnteroDto(personaEntity);
        personaEnteroDto.setPaciente(personaEntity.getPaciente());
        personaEnteroDto.setMedico(personaEntity.getMedico());
        personaRepository.deleteById(id);
        return personaEnteroDto;
    }

}
