package br.com.agenda_consultas.repository.impl;

import br.com.agenda_consultas.model.Paciente;
import br.com.agenda_consultas.repository.PacienteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public PacienteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void savePaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, data_nascimento, telefone, email, endereco) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, paciente.getNome(), paciente.getCpf(), paciente.getData_nascimento(),
                paciente.getTelefone(), paciente.getEmail(), paciente.getEndereco());
    }

    @Override
    public void updatePaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, " +
                "email = ?, endereco = ? WHERE id = ?";
        jdbcTemplate.update(sql, paciente.getNome(), paciente.getCpf(), paciente.getData_nascimento(),
                paciente.getTelefone(), paciente.getEmail(), paciente.getEndereco(), paciente.getId());
    }

    @Override
    public void deletePaciente(Long id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Paciente> findPacienteById(Long id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        List<Paciente> pacientes = jdbcTemplate.query(sql, new Object[]{id}, new PacienteRowMapper());
        return pacientes.stream().findFirst();
    }

    @Override
    public List<Paciente> findAll() {
        String sql = "SELECT * FROM paciente";
        return jdbcTemplate.query(sql, new PacienteRowMapper());
    }

    private static class PacienteRowMapper implements RowMapper<Paciente> {
        @Override
        public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Paciente paciente = new Paciente();
            paciente.setId(rs.getLong("id"));
            paciente.setNome(rs.getString("nome"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setData_nascimento(rs.getDate("data_nascimento"));
            paciente.setTelefone(rs.getString("telefone"));
            paciente.setEmail(rs.getString("email"));
            paciente.setEndereco(rs.getString("endereco"));
            return paciente;
        }
    }
}
