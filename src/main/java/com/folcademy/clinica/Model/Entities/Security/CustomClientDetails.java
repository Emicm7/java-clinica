package com.folcademy.clinica.Model.Entities.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

public class CustomClientDetails implements ClientDetails {

    private final Usuario usuario;

    public CustomClientDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getClientId() {
        return usuario.getUsuarioDesc();
    }

    @Override
    public Set<String> getResourceIds() {
        Set<String> resources = new HashSet<>();
        for (Resource resource : usuario.getResourceSet()) {
            resources.add(resource.name);
        }
        return resources;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {

        return usuario.getUsuarioClave();
    }

    @Override
    public boolean isScoped() {
        return usuario.getScopeSet().size() != 0;
    }

    @Override
    public Set<String> getScope() {
        Set<String> scopes = new HashSet<>();
        for (Scope scope : usuario.getScopeSet()) {
            scopes.add(scope.name);
        }
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        Set<String> authorized_grant_types = new HashSet<>();
        for (AuthorizedGrantTypes authorizedGrantType : usuario.getAuthorizedGrantTypesSet()) {
            authorized_grant_types.add(authorizedGrantType.name);
        }
        return authorized_grant_types;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : usuario.getAuthoritySet()) {
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return usuario.getAccesstokenvalidityseconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return usuario.getRefreshtokenvalidityseconds();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
