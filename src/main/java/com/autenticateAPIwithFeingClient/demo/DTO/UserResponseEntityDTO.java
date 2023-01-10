package com.autenticateAPIwithFeingClient.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseEntityDTO {
    private String cod;
    private String messange;
    private HttpStatus httpStatus;
}
