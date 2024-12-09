package com.amadeus.horas_extras.adapter.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JWTResponseDto {
    private String token;

    public JWTResponseDto(String token) {
        this.token = token;
    }

}
