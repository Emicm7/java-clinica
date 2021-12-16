package com.folcademy.clinica.Model.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persona")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    Integer idpersona;
    @Column(name = "Nombre")
    String nombre;
    @Column(name = "Apellido")
    String apellido;
    @Column(name = "dni")
    String dni;
    @Column(name = "Direccion")
    String direccion;
    @Column(name = "Telefono")
    String  telefono;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Persona persona = (Persona) o;
        return idpersona != null && Objects.equals(idpersona, persona.idpersona);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
