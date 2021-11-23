package com.folcademy.clinica.Model.Dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @NotNull
    Integer idPaciente;

    @NotNull
    Integer idMedico;


}
