package com.folcademy.clinica.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente", columnDefinition = "INT(10) UNSIGNED")
    public Integer idpaciente;
    @Column(name = "dni", columnDefinition = "VARCHAR")
    public String dni;
    @Column(name = "Nombre", columnDefinition = "VARCHAR")
    public String nombre;
    @Column(name = "Apellido", columnDefinition = "VARCHAR")
    public String apellido;
    @Column(name = "Telefono", columnDefinition = "VARCHAR")
    public String telefono;
}
