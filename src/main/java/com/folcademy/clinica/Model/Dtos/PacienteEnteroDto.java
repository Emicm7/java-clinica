package com.folcademy.clinica.Model.Dtos;

import com.folcademy.clinica.Model.Entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteEnteroDto {
    Integer idpaciente;

    Persona persona;
}
