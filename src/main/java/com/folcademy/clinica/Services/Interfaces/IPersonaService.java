package com.folcademy.clinica.Services.Interfaces;

import com.folcademy.clinica.Model.Dtos.PersonaDto;
import com.folcademy.clinica.Model.Dtos.PersonaEnteroDto;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;

import java.util.List;

public interface IPersonaService {
    List<PersonaEnteroDto> findAllPersonas();
    PersonaEnteroDto findPersonaById(Integer id);
    PersonaEnteroDto save(PersonaDto persona);
    PersonaEnteroDto edit(Integer idPersona, PersonaDto dto);
    PersonaEnteroDto delete(Integer id);
}
