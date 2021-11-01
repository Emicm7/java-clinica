package com.folcademy.clinica.Services;

import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Repositories.MedicoRepository;
import com.folcademy.clinica.Services.Interfaces.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> findAllMedicos() {

        return (List<Medico>) medicoRepository.findAll();


    }

    @Override
    public Medico findMedicoById(Integer id) {
        Medico medico = medicoRepository.findById(id).get();
        return medico;
    }
}
