package com.folcademy.clinica.Model.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medico")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    Integer idmedico;
    @Column(name = "Nombre")
    String nombre = "";
    @Column(name = "Apellido")
    String apellido;
    @Column(name = "Telefono")
    String telefono;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medico medico = (Medico) o;
        return idmedico != null && Objects.equals(idmedico, medico.idmedico);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

