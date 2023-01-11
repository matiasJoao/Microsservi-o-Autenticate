/* package com.autenticateAPIwithFeingClient.demo.Service.Utils;

import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Service
public class LoginResource {

    private final SecretKey key = Keys.hmacShaKeyFor("lEAnEZSLi8qbVhnHe3Cixkq7Ty2wMs6VVu8pjPZsNfrymC5pwvxTFMQmaGIKXCwGXsV47ImKLB9W42bqoy7R8L49fAH233yOkiIhQVSqmPceHduTzrzy0tv6R2YKUlm4tVb7ERnOwnT2qdJOt8cjpvd7n2F5bSXsDXp5CBJZOsP3uoHLlHUA2YvdO17NHU58Fi38JCVmVyddMKOVfwk7iD8Ws5xZOsXhBQd8hYi0ml3XTHGY3QTckQWCLkqnAdtZ".getBytes(StandardCharsets.UTF_8));
    @POST
    public Response post(UserEntity userEntity){
            try{
                if(userEntity.getEmail().equalsIgnoreCase("caba@email.com")) {
                    String jwtoke = Jwts.builder().setSubject(userEntity.getEmail())
                            .setIssuer("localhost:8081")
                            .setIssuedAt(new Date())
                            .setExpiration(
                                    Date.from(
                                            LocalDateTime.now().plusMinutes(15L)
                                                    .atZone(
                                                            ZoneId.systemDefault()
                                                    ).toInstant()
                                    )
                            ).signWith(SignatureAlgorithm.ES256, key)
                            .compact();
                    return Response.status(Response.Status.OK).entity(jwtoke).build();
                }
                else {
                    return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario nao autorizado").build();
                }
            }
            catch (Exception e){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(e.getMessage())
                        .build();
            }
    }
}


 */