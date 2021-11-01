package com.folcademy.clinica.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    public Integer idmedico;
    @Column(name = "Nombre")
    public String nombre;
    @Column(name = "Apellido")
    public String apellido;
    @Column(name = "Telefono")
    public String telefono;
}

