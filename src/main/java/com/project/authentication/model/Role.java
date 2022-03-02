package com.project.authentication.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "roles")
public enum Role implements GrantedAuthority {

    ADMIN,
    DENTISTA;

    public String getAuthority() {
        return name();
    }

}
