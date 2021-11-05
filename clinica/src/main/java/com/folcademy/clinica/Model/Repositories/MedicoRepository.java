package com.folcademy.clinica.Model.Repositories;

import com.folcademy.clinica.Model.Entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
