package br.com.agenda_consultas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profissional {

    private Integer id;
    private String nome;
    private String especialidade;
    private String crm;
    private Time horario_inicio;
    private Time horario_fim;

}
