package com.autenticateAPIwithFeingClient.demo.Service.Utils;

import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class Token {

        private final String secret = "lEAnEZSLi8qbVhnHe3Cixkq7Ty2wMs6VVu8pjPZsNfrymC5pwvxTFMQmaGIKXCwGXsV47ImKLB9W42bqoy7R8L49fAH233yOkiIhQVSqmPceHduTzrzy0tv6R2YKUlm4tVb7ERnOwnT2qdJOt8cjpvd7n2F5bSXsDXp5CBJZOsP3uoHLlHUA2YvdO17NHU58Fi38JCVmVyddMKOVfwk7iD8Ws5xZOsXhBQd8hYi0ml3XTHGY3QTckQWCLkqnAdtZ";



        public String generateToken(String email, UserEntity user) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("depart", user.getDepart());
              try {
                             return Jwts.builder().setIssuer("localhost:8081").setSubject(user.getEmail()).addClaims(claims).setIssuedAt(new Date())
                                     .setExpiration(new Date(new Date().getTime() + Long.parseLong("86400000"))).signWith(SignatureAlgorithm.HS256, secret).compact();
              }
              catch (Exception e){
                      return e.getMessage();
              }

        }
}

