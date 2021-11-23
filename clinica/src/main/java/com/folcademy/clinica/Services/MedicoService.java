package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.BadRequestException;
import com.folcademy.clinica.Exceptions.NotFoundException;
import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Mappers.MedicoMapper;
import com.folcademy.clinica.Model.Repositories.MedicoRepository;
import com.folcademy.clinica.Services.Interfaces.IMedicoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MedicoService implements IMedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper, MedicoMapper medicoMapper1) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper1;
    }


    @Override
    public List<MedicoDto> findAllMedicos() {
        List<MedicoDto> medicos=new ArrayList<>();
        List<Medico> medicosEntities= (List<Medico>) medicoRepository.findAll();
        if (medicosEntities.isEmpty())
            throw new NotFoundException("No se encontraron medicos");

        for (Medico medicoEntity : medicosEntities){
            medicos.add(medicoMapper.entityToDto(medicoEntity));
        }

        return medicos;


    }

    @Override
    public MedicoDto findMedicoById(Integer id) {
        if (!medicoRepository.existsById(id))
            throw new NotFoundException("No Existe el medico");
        Medico medicoEntity = medicoRepository.findById(id).orElse(null);
        MedicoDto medicoDto = medicoMapper.entityToDto(medicoEntity);
        return medicoDto;
    }

    @Override
    public MedicoDto save(Medico medico) {
        medico.setIdmedico(null);
        if (medico.getConsulta()<0)
            throw new BadRequestException("La consulta no puede ser menor a 0");
        medicoRepository.save(medico);
        MedicoDto medicoDto = medicoMapper.entityToDto(medico);
        return medicoDto;
    }

    public MedicoEnteroDto edit(Integer idMedico, MedicoEnteroDto dto) {
        if (!medicoRepository.existsById(idMedico))
            throw new NotFoundException("No existe el medico");
        dto.setIdmedico(idMedico);
        return medicoMapper.entityToEnteroDto(
                    medicoRepository.save(
                            medicoMapper.enteroDtoToEntity(
                                    dto
                            )
                    )
        );
    }

    public MedicoDto delete(Integer id) {
        if (!medicoRepository.existsById(id))
            throw new NotFoundException("No existe el medico");
        Medico medicoEntity = medicoRepository.findById(id).get();
        MedicoDto medicoDto = medicoMapper.entityToDto(medicoEntity);
        medicoRepository.deleteById(id);
        return medicoDto;
    }
}
