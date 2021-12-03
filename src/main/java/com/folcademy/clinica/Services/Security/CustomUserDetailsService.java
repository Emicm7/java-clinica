package com.folcademy.clinica.Services.Security;

import com.folcademy.clinica.Model.Entities.Security.Usuario;
import com.folcademy.clinica.Model.Mappers.UsuarioMapper;
import com.folcademy.clinica.Model.Repositories.Security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public CustomUserDetailsService(@Qualifier("usuarioRepository") UsuarioRepository usuarioRepository, @Qualifier("usuarioMapper") UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String usuarioDesc) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsuarioDesc(usuarioDesc);
        if (usuario.isPresent()) {
            return usuarioMapper.usuarioEntityToSpringSecurity(usuario.get());
        } else {
            throw new UsernameNotFoundException("No se encuentra el usuario con codigo: " + usuarioDesc);
        }
    }
}
