package com.folcademy.clinica.Services.Security;


import com.folcademy.clinica.Model.Entities.Security.CustomClientDetails;
import com.folcademy.clinica.Model.Entities.Security.Usuario;
import com.folcademy.clinica.Model.Repositories.Security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomClientDetailsService implements ClientDetailsService {
    private final UsuarioRepository usuarioRepository;

    public CustomClientDetailsService(@Qualifier("usuarioRepository") UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String usuarioDesc) throws ClientRegistrationException {
        Optional<Usuario> usuario = usuarioRepository.findByUsuarioDesc(usuarioDesc);
        if (usuario.isPresent()) {

            return new CustomClientDetails(usuario.get());
        } else {
            throw new ClientRegistrationException("No se encuentra el cliente con codigo: " + usuarioDesc);
        }
    }

}
