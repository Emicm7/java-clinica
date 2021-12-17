package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;

import java.util.List;

public interface IMedicoService {

    List<MedicoEnteroDto> findAllMedicos();
    MedicoEnteroDto findMedicoById(Integer id);
    MedicoEnteroDto save(MedicoDto medico);
    MedicoEnteroDto edit(Integer idMedico, MedicoDto dto);
    MedicoEnteroDto delete(Integer id);
}
