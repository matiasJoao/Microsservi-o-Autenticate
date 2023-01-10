package com.autenticateAPIwithFeingClient.demo.Service.Utils;


import com.autenticateAPIwithFeingClient.demo.UserEntity;
import feign.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LoginResource {

    private final SecretKey CHAVE = Keys.hmacShaKeyFor(
            "7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
                    .getBytes(StandardCharsets.UTF_8));

    public ResponseEntity response(UserEntity userEntity){

        try {
            if (userEntity.getDepart().equals("Cliente")) {
                String jwToken = Jwts.builder()
                        .setSubject(userEntity.getEmail())
                        .setIssuer("localhost:8081")
                        .setIssuedAt(new Date())
                        .setExpiration(Date.from(Instant.from(LocalDateTime.now()
                                .plusMinutes(15L)
                                .atZone(ZoneId.systemDefault())
                                .toInstant())))
                        .signWith(CHAVE, SignatureAlgorithm.RS512)
                        .compact();
                return ResponseEntity.status(HttpStatus.OK).body(jwToken);
            }
            else {
                return ResponseEntity.status(HttpStatus.OK)
            }
        }
        catch (

        )

    }


}
