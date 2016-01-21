package com.doomphantoom.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.Collection;

/**
 * Created by Trung on 12/21/2015.
 */
public class UserDetail implements UserDetails {
    private final org.springframework.security.core.userdetails.UserDetails user;

    public UserDetail(org.springframework.security.core.userdetails.UserDetails user) {
        this.user = user;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    public boolean isEnabled() {
        return user.isEnabled();
    }
}
