package com.folcademy.clinica.Model.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    public String  telefono;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paciente paciente = (Paciente) o;
        return idpaciente != null && Objects.equals(idpaciente, paciente.idpaciente);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
