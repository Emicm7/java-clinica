package com.folcademy.clinica.Model.Repositories;

import com.folcademy.clinica.Model.Entities.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface MedicoRepository extends PagingAndSortingRepository<Medico, Integer> {
}
