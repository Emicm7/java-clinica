package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.MedicoDto;
import com.folcademy.clinica.Model.Dtos.MedicoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;

import java.util.List;

public interface IMedicoService {

    List<MedicoDto> findAllMedicos();
    MedicoDto findMedicoById(Integer id);
    MedicoDto save(Medico medico);
    MedicoEnteroDto edit(Integer idMedico, MedicoEnteroDto dto);
    MedicoDto delete(Integer id);
}
