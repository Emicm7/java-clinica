package com.folcademy.clinica.Model.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEnteroDto {
    Integer id;

    String nombre;

    String apellido;

    String dni;

    String direccion;

    String telefono;
}
