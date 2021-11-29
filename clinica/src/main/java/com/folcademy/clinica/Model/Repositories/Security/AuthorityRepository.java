package com.folcademy.clinica.Model.Repositories.Security;

import com.folcademy.clinica.Model.Entities.Security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Optional<Authority> findById(Integer id);

    Optional<Authority> findByName(String name);

    List<Authority> findByIdIn(List<Integer> ids);

}

