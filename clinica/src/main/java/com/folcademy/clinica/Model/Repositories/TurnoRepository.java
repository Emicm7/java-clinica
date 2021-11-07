package com.folcademy.clinica.Model.Repositories;

import com.folcademy.clinica.Model.Entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
