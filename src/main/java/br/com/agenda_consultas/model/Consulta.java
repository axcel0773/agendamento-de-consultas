package br.com.agenda_consultas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    private Long id;
    private Long paciente_id;
    private Long profissional_id;
    private LocalDate data;
    private LocalTime hora;

}
