package com.folcademy.clinica.Model.Repositories.Security;

import com.folcademy.clinica.Model.Entities.Security.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesRepository extends JpaRepository<Resource,Integer> {
}
