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
    @Column(name = "idpaciente")
    Integer idpaciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Persona persona;

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
