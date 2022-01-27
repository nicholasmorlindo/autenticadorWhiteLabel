package com.project.autenticator.controller;

import com.project.autenticator.model.request.AutenticacaoRequest;
import com.project.autenticator.model.response.AutenticacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AutenticacaoResponse autenticar(@RequestBody @Valid AutenticacaoRequest autenticacaoRequest){
        UsernamePasswordAuthenticationToken loginData = autenticacaoRequest.toUsernamePasswordToken();

        try {
            Authentication authentication = authenticationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }



    }
}
