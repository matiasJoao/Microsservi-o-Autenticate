package com.autenticateAPIwithFeingClient.demo.Service;


import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.Service.Utils.Token;
import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   // @Autowired
   // LoginResource loginResource;
    @Autowired
    Token token;
    public String getLoginUser(UserDataDTO userDataDTO){
        UserEntity userEntity = new UserEntity(userDataDTO.getEmail(), userDataDTO.getSenha(), userDataDTO.getDepart());
       return  token.generateToken(userDataDTO.getEmail(), userEntity);
    }

    public Boolean validToken(String tkn){
        return token.tokenValid(tkn);
    }
    public String typeUser(String tkn){
        return token.typeUser(tkn);
    }

}
