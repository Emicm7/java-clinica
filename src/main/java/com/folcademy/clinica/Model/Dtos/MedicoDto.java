package com.folcademy.clinica.Model.Dtos;

import com.folcademy.clinica.Model.Entities.Persona;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDto {
    Integer id;

    String nombre;

    String apellido;

    @NotNull
    String profesion;

    @NotNull
    Integer consulta;

    Persona persona;
}
