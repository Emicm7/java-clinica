package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.BadRequestException;
import com.folcademy.clinica.Exceptions.NotFoundException;
import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Persona;
import com.folcademy.clinica.Model.Mappers.MedicoMapper;
import com.folcademy.clinica.Model.Repositories.MedicoRepository;
import com.folcademy.clinica.Model.Repositories.PersonaRepository;
import com.folcademy.clinica.Services.Interfaces.IMedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MedicoService implements IMedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;
    private final PersonaRepository personaRepository;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper, MedicoMapper medicoMapper1, PersonaRepository personaRepository) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper1;
        this.personaRepository = personaRepository;
    }



    public List<MedicoEnteroDto> findAllMedicos() {
        List<MedicoEnteroDto> medicos=new ArrayList<>();
        List<Medico> medicosEntities= (List<Medico>) medicoRepository.findAll();
        if (medicosEntities.isEmpty())
            throw new NotFoundException("No se encontraron medicos");

        for (Medico medicoEntity : medicosEntities){
            MedicoEnteroDto dto = medicoMapper.entityToEnteroDto(medicoEntity);
            dto.setPersona(medicoEntity.getPersona());
            medicos.add(dto);
        }

        return medicos;
    }

    @Override
    public MedicoEnteroDto findMedicoById(Integer id) {
        if (!medicoRepository.existsById(id))
            throw new NotFoundException("No Existe el medico");
        Medico medicoEntity = medicoRepository.findById(id).get();
        MedicoEnteroDto medicoEnteroDto = medicoMapper.entityToEnteroDto(medicoEntity);
        medicoEnteroDto.setPersona(medicoEntity.getPersona());
        return medicoEnteroDto;
    }

    @Override
    public MedicoEnteroDto save(MedicoDto medico) {
        medico.setId(null);
        if (medico.getConsulta()<0)
            throw new BadRequestException("La consulta no puede ser menor a 0");
        Persona persona = new Persona();
        persona.setIdpersona(null);
        persona.setNombre(medico.getNombre());
        persona.setApellido(medico.getApellido());
        persona.setDni(medico.getDni());
        persona.setTelefono(medico.getTelefono());
        persona.setDireccion(medico.getDireccion());
        personaRepository.save(persona);
        Medico medicoEntity = new Medico();
        medicoEntity.setConsulta(medico.getConsulta());
        medicoEntity.setProfesion(medico.getProfesion());
        medicoEntity.setPersona(persona);
        medicoRepository.save(medicoEntity);
        MedicoEnteroDto medicoEnteroDto = new MedicoEnteroDto();
        medicoEnteroDto.setIdmedico(medicoEntity.getIdmedico());
        medicoEnteroDto.setConsulta(medicoEntity.getConsulta());
        medicoEnteroDto.setProfesion(medicoEntity.getProfesion());
        medicoEnteroDto.setPersona(persona);
        return medicoEnteroDto;
    }

    public MedicoEnteroDto edit(Integer idMedico, MedicoDto dto) {
        if (!medicoRepository.existsById(idMedico))
            throw new NotFoundException("No existe el medico");
        Medico medicoEntity = medicoRepository.findById(idMedico).get();
        medicoEntity.setProfesion(dto.getProfesion());
        medicoEntity.setConsulta(dto.getConsulta());
        medicoRepository.save(medicoEntity);
        MedicoEnteroDto medicoEnteroDto = medicoMapper.entityToEnteroDto(medicoEntity);
        medicoEnteroDto.setPersona(medicoEntity.getPersona());
        return medicoEnteroDto;
    }

    public MedicoEnteroDto delete(Integer id) {
        if (!medicoRepository.existsById(id))
            throw new NotFoundException("No existe el medico");
        Medico medicoEntity = medicoRepository.findById(id).get();
        MedicoEnteroDto medicoEnteroDto = medicoMapper.entityToEnteroDto(medicoEntity);
        medicoEnteroDto.setPersona(medicoEntity.getPersona());
        medicoRepository.deleteById(id);
        return medicoEnteroDto;
    }

    public Page<Medico> findAllByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return medicoRepository.findAll(pageable);
    }
}
