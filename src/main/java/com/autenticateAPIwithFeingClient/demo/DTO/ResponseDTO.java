package com.autenticateAPIwithFeingClient.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String mensagem;
    private String codigo;
    private HttpStatus httpStatus;
}

