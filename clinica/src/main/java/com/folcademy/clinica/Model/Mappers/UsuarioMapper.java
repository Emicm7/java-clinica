package com.folcademy.clinica.Model.Mappers;

import com.folcademy.clinica.Model.Entities.Security.Authority;
import com.folcademy.clinica.Model.Entities.Security.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("usuarioMapper")
public class UsuarioMapper {

    public org.springframework.security.core.userdetails.User usuarioEntityToSpringSecurity(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : usuario.getAuthoritySet()) {
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsuarioDesc(),
                usuario.getUsuarioClave(),
                usuario.getUsuarioDelete().equals(0),
                true,
                true,
                true,
                authorities
        );
    }
}

