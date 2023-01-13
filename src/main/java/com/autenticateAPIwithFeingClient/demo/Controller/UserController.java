package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.TokenDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingUserRepository;
import com.autenticateAPIwithFeingClient.demo.Service.UserService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    @RequestMapping("/login")
    public ResponseEntity getUser(@RequestBody UserDataDTO userDataDTO ){
        String token = userService.getLoginUser(userDataDTO);
        TokenDTO tokenDTO = new TokenDTO("Bearer", token);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }
    @GetMapping
    @RequestMapping("/validation")
    public Boolean getToken(@RequestHeader(HttpHeaders.AUTHORIZATION)String token){
     String tkn =  token.split(" ")[1];
      return userService.validToken(tkn);
    }
    @GetMapping
    @RequestMapping("/type")
    public String typeUSer(@RequestHeader(HttpHeaders.AUTHORIZATION)String token){
        String tkn =  token.split(" ")[1];
        return userService.typeUser(tkn);
    }

}
