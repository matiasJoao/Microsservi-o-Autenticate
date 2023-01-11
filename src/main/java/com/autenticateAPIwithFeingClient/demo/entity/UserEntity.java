package com.autenticateAPIwithFeingClient.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String email;
    private String senha;
    private Object depart;
}
