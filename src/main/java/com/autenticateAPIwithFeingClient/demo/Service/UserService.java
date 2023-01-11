package com.autenticateAPIwithFeingClient.demo.Service;


import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserResponseEntityDTO;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingUserRepository;
import com.autenticateAPIwithFeingClient.demo.Service.Utils.Token;
import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    FeingUserRepository feingUserRepository;
   // @Autowired
   // LoginResource loginResource;
    @Autowired
    Token token;
    public String getLoginUser(String email, String senha){
        UserDataDTO userdataDTO = feingUserRepository.getLoginUser(email, senha);
        UserEntity user = new  UserEntity(userdataDTO.getEmail(), userdataDTO.getSenha(), userdataDTO.getDepart());
     // return loginResource.post(user);
        return token.generateToken(email, user);

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
