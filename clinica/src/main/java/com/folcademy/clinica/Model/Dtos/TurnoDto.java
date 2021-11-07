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
public class TurnoDto {
    Integer id;

    @NotNull
    Date fecha;

    @NotNull
    Time hora;

    @NotNull
    int atendido;
}
