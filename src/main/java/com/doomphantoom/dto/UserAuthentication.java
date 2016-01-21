package com.doomphantoom.dto;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Trung on 12/21/2015.
 */
public class UserAuthentication implements Authentication {
    private final org.springframework.security.core.userdetails.User user;
    private boolean authenticated;

    public UserAuthentication(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    public Object getCredentials() {
        return user.getPassword();
    }

    public Object getDetails() {
        return user;
    }

    public Object getPrincipal() {
        return user.getUsername();
    }

    public boolean isAuthenticated() {
        return false;
    }

    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    public String getName() {
        return user.getUsername();
    }
}
