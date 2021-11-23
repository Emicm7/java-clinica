package com.folcademy.clinica.Services;

import com.folcademy.clinica.Exceptions.BadRequestException;
import com.folcademy.clinica.Exceptions.NotFoundException;
import com.folcademy.clinica.Model.Dtos.TurnoDto;
import com.folcademy.clinica.Model.Dtos.TurnoEnteroDto;
import com.folcademy.clinica.Model.Entities.Medico;
import com.folcademy.clinica.Model.Entities.Paciente;
import com.folcademy.clinica.Model.Entities.Turno;
import com.folcademy.clinica.Model.Mappers.TurnoMapper;
import com.folcademy.clinica.Model.Repositories.MedicoRepository;
import com.folcademy.clinica.Model.Repositories.PacienteRepository;
import com.folcademy.clinica.Model.Repositories.TurnoRepository;
import com.folcademy.clinica.Services.Interfaces.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TurnoService implements ITurnoService {
    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;


    public TurnoService(TurnoRepository turnoRepository, TurnoMapper turnoMapper, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<TurnoEnteroDto> findAllTurnos() {
        List<TurnoEnteroDto> turnos=new ArrayList<>();
        List<Turno> turnosEntities= (List<Turno>) turnoRepository.findAll();
        if (turnosEntities.isEmpty())
            throw new NotFoundException("No se encontraron turnos disponibles");

        for (Turno turnoEntity : turnosEntities){
            TurnoEnteroDto turno = turnoMapper.entityToEnteroDto(turnoEntity);
            turno.setPaciente(turnoEntity.getPaciente());
            turno.setMedico(turnoEntity.getMedico());
            turnos.add(turno);
        }

        return turnos;


    }

    @Override
    public TurnoEnteroDto findTurnoById(Integer id) {
        if (!turnoRepository.existsById(id))
            throw new NotFoundException("No existe este turno");
        Turno turnoEntity = turnoRepository.findById(id).orElse(null);
        TurnoEnteroDto turnoEnteroDto = turnoMapper.entityToEnteroDto(turnoEntity);
        turnoEnteroDto.setPaciente(turnoEntity.getPaciente());
        turnoEnteroDto.setMedico(turnoEntity.getMedico());
        return turnoEnteroDto;
    }

    @Override
    public TurnoEnteroDto save(TurnoDto turno) {
        if (turno.getAtendido()<0)
            throw new BadRequestException("El campo Atendido no puede ser menor a 0");
        Turno turnoEntity = turnoMapper.dtoToEntity(turno);
        Paciente paciente = pacienteRepository.findById(turno.getIdPaciente()).get();
        Medico medico = medicoRepository.findById(turno.getIdMedico()).get();
        turnoEntity.setMedico(medico);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setIdMedico(turno.getIdMedico());
        turnoEntity.setIdPaciente(turno.getIdPaciente());
        turnoRepository.save(turnoEntity);
        TurnoEnteroDto turnoEnteroDto = turnoMapper.entityToEnteroDto(turnoEntity);
        turnoEnteroDto.setPaciente(paciente);
        turnoEnteroDto.setMedico(medico);
        return turnoEnteroDto;
    }

    public TurnoEnteroDto edit(Integer idTurno, TurnoDto dto) {
        if (!turnoRepository.existsById(idTurno))
            throw new NotFoundException("No existe el turno");
        Turno turnoEntity = turnoMapper.dtoToEntity(dto);
        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente()).get();
        Medico medico = medicoRepository.findById(dto.getIdMedico()).get();
        turnoEntity.setMedico(medico);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setIdMedico(dto.getIdMedico());
        turnoEntity.setIdPaciente(dto.getIdPaciente());
        turnoRepository.save(turnoEntity);
        TurnoEnteroDto turnoEnteroDto = turnoMapper.entityToEnteroDto(turnoEntity);
        turnoEnteroDto.setPaciente(paciente);
        turnoEnteroDto.setMedico(medico);
        return turnoEnteroDto;
    }

    public TurnoEnteroDto delete(Integer id) {
        if (!turnoRepository.existsById(id))
            throw new NotFoundException("No existe el turno");
        Turno turnoEntity = turnoRepository.findById(id).get();
        TurnoEnteroDto turnoEnteroDto = turnoMapper.entityToEnteroDto(turnoEntity);
        turnoEnteroDto.setPaciente(turnoEntity.getPaciente());
        turnoEnteroDto.setMedico(turnoEntity.getMedico());
        turnoRepository.deleteById(id);
        return turnoEnteroDto;
    }

}
