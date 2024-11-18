package com.amadeus.horas_extras.adapter.api.security;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
public class UserDetailsImp implements UserDetails {

    private  final Employ employ;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return employ.getPassword();
    }

    @Override
    public String getUsername() {
        return employ.getEmail();
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
    public String getName(){
        return employ.getName();
    }
}
