package com.project.autenticator.model.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AutenticacaoRequest {

    private String email;
    private String senha;


    public UsernamePasswordAuthenticationToken toUsernamePasswordToken() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
