package com.folcademy.clinica.Model.Entities.Security;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid", columnDefinition = "INT(10) UNSIGNED")
    private Integer usuarioId;
    @Column(name = "usuariocodigo", columnDefinition = "VARCHAR")
    private String usuarioCodigo;
    @Column(name = "usuariodesc", columnDefinition = "VARCHAR")
    private String usuarioDesc;
    @Column(name = "usuarioclave", columnDefinition = "VARCHAR")
    private String usuarioClave;
    @Column(name = "usuariohabi")
    private double usuarioHabi;
    @Column(name = "usuariodelete")
    private Integer usuarioDelete;
    @Column(name = "accesstokenvalidityseconds")
    private int accesstokenvalidityseconds;
    @Column(name = "refreshtokenvalidityseconds")
    private int refreshtokenvalidityseconds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_authorities",
            joinColumns = @JoinColumn(name = "usuarioid"),
            inverseJoinColumns = @JoinColumn(name = "id_authority"))
    private List<Authority> authoritySet = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_scopes",
            joinColumns = @JoinColumn(name = "usuarioid"),
            inverseJoinColumns = @JoinColumn(name = "id_scope"))
    private Set<Scope> scopeSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_resources",
            joinColumns = @JoinColumn(name = "usuarioid"),
            inverseJoinColumns = @JoinColumn(name = "id_resource"))
    private Set<Resource> resourceSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_authorized_grant_types",
            joinColumns = @JoinColumn(name = "usuarioid"),
            inverseJoinColumns = @JoinColumn(name = "id_authorized_grant_types"))
    private Set<AuthorizedGrantTypes> authorizedGrantTypesSet = new HashSet<>();
}

