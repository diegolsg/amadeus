package com.amadeus.horas_extras.adapter.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class LoginRequestDto {
    private String email;
    private String password;
}
