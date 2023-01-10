package com.autenticateAPIwithFeingClient.demo.Service;


import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserResponseEntityDTO;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    FeingUserRepository feingUserRepository;

    public UserDataDTO getUser(String email, String senha){
        UserDataDTO userdataDTO = feingUserRepository.getUser(email, senha);
        return userdataDTO;
    }
    public ResponseEntity postUSer(UserPostDTO userPostDTO){
        feingUserRepository.postUser(userPostDTO);
        UserResponseEntityDTO userResponseEntityDTO = new UserResponseEntityDTO("200","Usuario Cadastrado", HttpStatus.OK);
        return  ResponseEntity.status(HttpStatus.OK).body(userResponseEntityDTO);
    }
}
