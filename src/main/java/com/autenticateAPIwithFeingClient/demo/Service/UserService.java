package com.autenticateAPIwithFeingClient.demo.Service;


import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserResponseEntityDTO;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingUserRepository;
import com.autenticateAPIwithFeingClient.demo.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {

    @Autowired
    FeingUserRepository feingUserRepository;

    public UserDataDTO getLoginUser(String email, String senha){
        UserDataDTO userdataDTO = feingUserRepository.getLoginUser(email, senha);
        new UserEntity(userdataDTO.getEmail(), userdataDTO.getSenha(), userdataDTO.getDepart());
        return  userdataDTO;
    }
    public ResponseEntity postUSer(UserPostDTO userPostDTO){
        feingUserRepository.postUser(userPostDTO);
        UserResponseEntityDTO userResponseEntityDTO = new UserResponseEntityDTO("200","Usuario Cadastrado", HttpStatus.OK);
        return  ResponseEntity.status(HttpStatus.OK).body(userResponseEntityDTO);
    }
    public List<UserDataDTO> getAllUsers(){
        return feingUserRepository.getAllUsers();
    }
}
