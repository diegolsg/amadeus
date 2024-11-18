package com.amadeus.horas_extras.adapter.api.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
