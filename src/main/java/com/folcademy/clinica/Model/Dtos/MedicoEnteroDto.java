package com.folcademy.clinica.Model.Dtos;

import com.folcademy.clinica.Model.Entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoEnteroDto {
    Integer idmedico;

    String nombre;

    String apellido;

    String profesion;

    Integer consulta;

    Persona persona;

}
