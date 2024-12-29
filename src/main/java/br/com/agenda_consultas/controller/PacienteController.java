package br.com.agenda_consultas.controller;

import br.com.agenda_consultas.model.Paciente;
import br.com.agenda_consultas.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarPaciente(@RequestBody Paciente paciente) {
        pacienteService.salvarPaciente(paciente);
    }



}
