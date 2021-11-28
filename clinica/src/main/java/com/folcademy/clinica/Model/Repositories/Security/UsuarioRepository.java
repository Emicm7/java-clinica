package com.folcademy.clinica.Model.Repositories.Security;

import com.folcademy.clinica.Model.Entities.Security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuarioCodigo(String usuarioCodigo);
    Optional<Usuario> findByUsuarioDesc(String usuarioDesc);

}
