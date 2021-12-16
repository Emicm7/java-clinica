package com.folcademy.clinica.Model.Dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    Integer id;

    @NotNull
    String nombre;

    @NotNull
    String apellido;

    @NotNull
    String dni;


    String direccion;


    String telefono;


}
