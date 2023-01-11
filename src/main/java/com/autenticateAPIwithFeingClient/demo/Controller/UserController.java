package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.TokenDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
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


    @GetMapping
    @RequestMapping("/userLogin/email/{email}/password/{senha}")
    public ResponseEntity getUser(@PathVariable("email")String email, @PathVariable("senha")String senha){
       String token = userService.getLoginUser(email, senha);
       TokenDTO tokenDTO = new TokenDTO("Bearer", token);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }
    @GetMapping
    @RequestMapping("/userlist")
    public List<UserDataDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    @RequestMapping("/userCadastro")
    public ResponseEntity postUser(@RequestBody UserPostDTO userPostDTO){
        return userService.postUSer(userPostDTO);
    }


}
