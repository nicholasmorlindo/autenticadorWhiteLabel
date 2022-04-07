package com.project.authentication.controller;

import com.project.authentication.model.request.AuthenticationRequest;
import com.project.authentication.model.response.AuthenticationResponse;
import com.project.authentication.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponse> autenticar(@RequestBody @Valid AuthenticationRequest authenticationRequest) throws AuthenticationException{
        UsernamePasswordAuthenticationToken loginData = authenticationRequest.toUsernamePasswordToken();
        try {
            Authentication authentication = authenticationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new AuthenticationResponse(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
