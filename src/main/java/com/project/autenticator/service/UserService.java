package com.project.autenticator.service;

import com.project.autenticator.model.User;
import com.project.autenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUser(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isPresent()){
            return user;
        }

        throw new UsernameNotFoundException("Usuario ou senha incorretos!");
    }
}
