package com.autenticateAPIwithFeingClient.demo.Service.Utils;

import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.http.MediaType.*;

@Service
public class LoginResource {

    private final SecretKey CHAVE = Keys.hmacShaKeyFor(
            "b638fa08-53aa-45cd-aac3-eb98dc7d80c1"
                    .getBytes(StandardCharsets.UTF_8));

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
                            ).signWith(CHAVE, SignatureAlgorithm.RS512)
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
