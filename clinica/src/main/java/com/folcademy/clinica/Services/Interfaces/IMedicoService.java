package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Entities.Medico;

import java.util.List;

public interface IMedicoService {

    List<Medico> findAllMedicos();
    Medico findMedicoById(Integer id);
}
