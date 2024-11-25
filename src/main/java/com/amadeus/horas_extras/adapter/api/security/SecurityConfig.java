package com.amadeus.horas_extras.adapter.api.security;

import com.amadeus.horas_extras.domain.port.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    private final UserService _userService;
//    private final JwtUtil _jwtUtil;
//
//    public SecurityConfig(UserService userService, JwtUtil jwtUtil) {
//        this._userService = userService;
//        this._jwtUtil = jwtUtil;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeRequests()
//            .requestMatchers("/auth/**").permitAll()
//            .requestMatchers("/users/index").hasRole("ADMIN")
//            .requestMatchers("/users/getByEmail").hasAnyRole("USER", "ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Add JWT filter
//        http.addFilterBefore(new JwtAuthenticationFilter(_jwtUtil, _userService), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(_userService)
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }
}