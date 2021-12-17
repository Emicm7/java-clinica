package com.folcademy.clinica.Model.Dtos;

import com.folcademy.clinica.Model.Entities.Persona;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {
    Integer id;

    String nombre;

    String apellido;

    Integer dni;

    Integer telefono;

    Persona persona;
}
