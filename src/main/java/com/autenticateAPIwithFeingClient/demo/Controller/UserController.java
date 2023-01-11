package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import com.autenticateAPIwithFeingClient.demo.Service.UserService;
import com.autenticateAPIwithFeingClient.demo.Service.Utils.LoginResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginResource loginResource;

    @GetMapping
    @RequestMapping("/userLogin/email/{email}/password/{senha}")
    public Object getUser(@PathVariable("email")String email, @PathVariable("senha")String senha){
        return userService.getLoginUser(email, senha);
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
