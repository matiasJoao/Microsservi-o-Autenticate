package com.autenticateAPIwithFeingClient.demo.Service;


import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingUserRepository;
import com.autenticateAPIwithFeingClient.demo.Service.Utils.Token;
import com.autenticateAPIwithFeingClient.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticateService {

   @Autowired
    FeingUserRepository feingUserRepository;
    @Autowired
    Token token;
    public String getLoginUser(UserDataDTO userDataDTO){
        UserDataDTO userDataDTO1 = feingUserRepository.getLoginUser(userDataDTO);
        UserEntity user = new  UserEntity(userDataDTO1.getEmail(), userDataDTO1.getSenha(), userDataDTO1.getDepart());
        return token.generateToken(user);
    }

    public Boolean validToken(String tkn){
        return token.tokenValid(tkn);
    }
    public String typeUser(String tkn){
        return token.typeUser(tkn);
    }

}
