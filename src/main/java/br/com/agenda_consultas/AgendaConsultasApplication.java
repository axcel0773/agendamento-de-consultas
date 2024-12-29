package br.com.agenda_consultas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootApplication
public class AgendaConsultasApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AgendaConsultasApplication.class);
	private final DataSource dataSource;

	public AgendaConsultasApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaConsultasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			if (connection != null) {
				logger.info("Conexão com o banco de dados bem-sucedida");
			} else {
				logger.error("Falha na conexão com o banco de dados");
			}

		} catch (SQLException exception) {
			logger.error("Erro ao tentar se conectar ao banco de dados: {}", exception.getMessage(), exception);
		}
	}

}
