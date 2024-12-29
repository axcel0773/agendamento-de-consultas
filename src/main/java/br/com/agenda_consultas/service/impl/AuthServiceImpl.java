package br.com.agenda_consultas.service.impl;

import br.com.agenda_consultas.service.AuthService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.secret}")
    private String secretKey;  // A chave secreta é injetada do arquivo application.properties

    @Value("${jwt.expiration}")
    private long expirationTime;  // O tempo de expiração também vem do application.properties

    @Override
    public String authenticate(String username, String password) {
        // Aqui você pode adicionar lógica para autenticar o usuário, como verificar um banco de dados
        // Para o exemplo, vamos usar uma validação simples
        if ("usuario".equals(username) && "senha".equals(password)) {  // Exemplo simples de validação
            return generateToken(username);  // Gera o token JWT para o usuário autenticado
        }
        throw new RuntimeException("Credenciais inválidas");  // Lançar uma exceção em caso de falha
    }

    private String generateToken(String username) {
        // Geração do token JWT
        return JWT.create()
                .withSubject(username)  // Define o nome de usuário como "subject" do token
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))  // Define a expiração do token
                .sign(Algorithm.HMAC256(secretKey));  // Assina o token com a chave secreta
    }
}