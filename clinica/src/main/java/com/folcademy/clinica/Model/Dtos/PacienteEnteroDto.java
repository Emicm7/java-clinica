package com.folcademy.clinica.Model.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteEnteroDto {
    Integer idpaciente;

    String dni;

    String nombre;

    String apellido;

    String telefono;
}
