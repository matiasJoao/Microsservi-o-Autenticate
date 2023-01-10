package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import com.autenticateAPIwithFeingClient.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/userLogin/email/{email}/password/{senha}")
    public UserDataDTO getUser(@PathVariable("email")String email, @PathVariable("senha")String senha){
        return userService.getUser(email, senha);
    }

    @PostMapping
    @RequestMapping("/userCadastro")
    public ResponseEntity postUser(@RequestBody UserPostDTO userPostDTO){
        return userService.postUSer(userPostDTO);
    }
}
