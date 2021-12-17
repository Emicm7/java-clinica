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
    @Column(name = "Profesion")
    String profesion;
    @Column(name = "Consulta")
    Integer consulta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Persona persona;

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

