package com.folcademy.clinica.Model.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "turno")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idturno")
    Integer idturno;

    @Column(name = "Fecha")
    Date fecha;

    @Column(name = "Hora")
    Time hora;

    @Column(name = "Atendido")
    int atendido;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Turno turno = (Turno) o;
        return idturno != null && Objects.equals(idturno, turno.idturno);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
