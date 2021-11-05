package com.folcademy.clinica.Model.Dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDto {
    Integer id;

    @NotNull
    String nombre;

    @NotNull
    String apellido;

    @NotNull
    String telefono;
}
