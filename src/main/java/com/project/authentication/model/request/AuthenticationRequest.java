package com.project.authentication.model.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationRequest {

    private String email;
    private String password;


    public UsernamePasswordAuthenticationToken toUsernamePasswordToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
