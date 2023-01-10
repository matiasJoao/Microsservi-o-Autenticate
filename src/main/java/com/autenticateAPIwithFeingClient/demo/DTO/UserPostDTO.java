package com.autenticateAPIwithFeingClient.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {
    private String name;
    private String email;
    private String cpf;
    private String senha;
    private Object depart;

}
