package br.com.agenda_consultas.service;

import br.com.agenda_consultas.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {


    void salvarPaciente(Paciente paciente);
    void atualizarPaciente(Paciente paciente);
    void deletarPaciente(Long id);
    Optional<Paciente> buscarPacientePorId(Long id);
    List<Paciente> listarTodosPacientes();

}
