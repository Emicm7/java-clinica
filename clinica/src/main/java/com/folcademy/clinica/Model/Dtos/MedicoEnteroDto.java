package com.folcademy.clinica.Model.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoEnteroDto {
    Integer idmedico;

    String nombre = "";

    String apellido = "";

    String telefono;
}
