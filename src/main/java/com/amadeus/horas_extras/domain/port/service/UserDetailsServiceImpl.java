package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.jpa.BossJpaRepository;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import com.amadeus.horas_extras.domain.port.repository.BossRepository;
import com.amadeus.horas_extras.domain.port.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployJpaRepository employRepository;

    @Autowired
    private BossJpaRepository bossRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Boss boss = bossRepository.findByEmail(email);
        if (boss != null) {
            return new User(boss.getEmail(), boss.getPassword(),
                    Collections.singleton(() -> "ROLE_BOSS"));
        }

        Employ employ = employRepository.findByEmail(email);
        if (employ != null) {
            return new User(employ.getEmail(), employ.getPassword(),
                    Collections.singleton(() -> "ROLE_EMPLOY"));
        }

        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}

