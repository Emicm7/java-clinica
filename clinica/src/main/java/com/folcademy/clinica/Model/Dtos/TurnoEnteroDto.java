package com.folcademy.clinica.Model.Dtos;

import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoEnteroDto {
    Integer idTurno;

    Date fecha;

    Time hora;

    int atendido;

    Paciente paciente;

    Medico medico;


}
