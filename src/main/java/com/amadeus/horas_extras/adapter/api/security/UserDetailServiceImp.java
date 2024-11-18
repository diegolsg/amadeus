package com.amadeus.horas_extras.adapter.api.security;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private EmployJpaRepository jpaRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employ employ = jpaRepository.findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("email"+email+"no existe"));
        return new UserDetailsImp(employ);
    }
}
