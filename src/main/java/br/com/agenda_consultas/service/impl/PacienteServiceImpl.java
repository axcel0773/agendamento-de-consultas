package br.com.agenda_consultas.service.impl;

import br.com.agenda_consultas.model.Paciente;
import br.com.agenda_consultas.repository.PacienteRepository;
import br.com.agenda_consultas.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void salvarPaciente(Paciente paciente) {
        pacienteRepository.savePaciente(paciente);
    }

    @Override
    public void atualizarPaciente(Paciente paciente) {
        pacienteRepository.updatePaciente(paciente);
    }

    @Override
    public void deletarPaciente(Long id) {
        pacienteRepository.deletePaciente(id);
    }

    @Override
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findPacienteById(id);
    }

    @Override
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }
}
