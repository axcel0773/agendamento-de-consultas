package br.com.agenda_consultas.repository;

import br.com.agenda_consultas.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository {

    void savePaciente(Paciente paciente);
    void updatePaciente(Paciente paciente);
    void deletePaciente(Long id);

    Optional<Paciente> findPacienteById(Long id);
    List<Paciente> findAll();
}
