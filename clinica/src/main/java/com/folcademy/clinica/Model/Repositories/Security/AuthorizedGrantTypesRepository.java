package com.folcademy.clinica.Model.Repositories.Security;

import com.folcademy.clinica.Model.Entities.Security.AuthorizedGrantTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedGrantTypesRepository extends JpaRepository<AuthorizedGrantTypes,Integer> {
}
