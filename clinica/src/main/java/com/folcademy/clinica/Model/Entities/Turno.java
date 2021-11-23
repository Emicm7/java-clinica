package com.folcademy.clinica.Model.Entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
    Integer idTurno;

    @Column(name = "Fecha")
    Date fecha;

    @Column(name = "Hora")
    Time hora;

    @Column(name = "Atendido")
    int atendido;

    @Column(name = "idpaciente")
    Integer idPaciente;

    @Column(name = "idmedico")
    Integer idMedico;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "idmedico", referencedColumnName = "idmedico", insertable = false, updatable = false)
    private Medico medico;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Turno turno = (Turno) o;
        return idTurno != null && Objects.equals(idTurno, turno.idTurno);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
