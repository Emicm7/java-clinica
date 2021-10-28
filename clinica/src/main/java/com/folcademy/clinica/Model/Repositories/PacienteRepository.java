package com.folcademy.clinica.Model.Repositories;

import com.folcademy.clinica.Model.Entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Integer> {

    Page<Paciente> findAllByApellido(String apellido, Pageable pageable);

}
