package com.project.autenticator.repository;

import com.project.autenticator.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    Optional<User> findByEmail(String username);
}
