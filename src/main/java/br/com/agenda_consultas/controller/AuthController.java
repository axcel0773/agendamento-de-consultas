package br.com.agenda_consultas.controller;

import br.com.agenda_consultas.model.Usuario;
import br.com.agenda_consultas.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return authService.authenticate(usuario.getUsername(), usuario.getPassword());
    }

}
