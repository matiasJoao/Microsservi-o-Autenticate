package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.TokenDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    @RequestMapping("/autentication")
    public ResponseEntity getUser(@RequestBody UserDataDTO userDataDTO ){
       String token = userService.getLoginUser(userDataDTO);
       TokenDTO tokenDTO = new TokenDTO("Bearer", token);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }

}
