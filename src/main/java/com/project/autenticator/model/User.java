package com.project.autenticator.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String full_name;

    @NotEmpty @Email @Column(unique = true)
    private String email;

    @CPF
    private String identityNumber;

    @NotEmpty
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();

    public User(){}

    public User(String full_name, String email, String profession, String identityNumber, String password) {
        this.full_name = full_name;
        this.email = email;
        this.identityNumber = identityNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
