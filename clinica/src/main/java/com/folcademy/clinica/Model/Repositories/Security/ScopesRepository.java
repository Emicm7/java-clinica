package com.folcademy.clinica.Model.Repositories.Security;

import com.folcademy.clinica.Model.Entities.Security.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopesRepository extends JpaRepository<Scope,Integer> {
}
