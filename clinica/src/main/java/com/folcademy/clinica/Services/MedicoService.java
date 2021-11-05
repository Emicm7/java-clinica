package com.folcademy.clinica.Services;

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

        for (Medico medicoEntity : medicosEntities){
            medicos.add(medicoMapper.entityToDto(medicoEntity));
        }

        return medicos;


    }

    @Override
    public MedicoDto findMedicoById(Integer id) {
        Medico medicoEntity = medicoRepository.findById(id).orElse(null);
        MedicoDto medicoDto = medicoMapper.entityToDto(medicoEntity);
        return medicoDto;
    }

    @Override
    public MedicoDto save(Medico medico) {
        if (Objects.isNull(medico.getNombre())
                || Objects.isNull(medico.getTelefono())
                || Objects.isNull(medico.getApellido()))
            return null;
        medico.setIdmedico(null);
        medicoRepository.save(medico);
        MedicoDto medicoDto = medicoMapper.entityToDto(medico);
        return medicoDto;
    }

    public MedicoEnteroDto edit(Integer idMedico, MedicoEnteroDto dto) {
        if (!medicoRepository.existsById(idMedico))
            return null;
        dto.setIdmedico(idMedico);
        return medicoMapper.entityToEnteroDto(
                    medicoRepository.save(
                            medicoMapper.enteroDtoToEntity(
                                    dto
                            )
                    )
        );





    }

    public boolean delete(Integer id) {
        if (!medicoRepository.existsById(id))
            return false;
        medicoRepository.deleteById(id);
        return true;
    }
}
