package com.autenticateAPIwithFeingClient.demo.Repository;

import com.autenticateAPIwithFeingClient.demo.DTO.ProductsPostDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.UserPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "User", url = "localhost:8082")
public interface FeingUserRepository {

    @GetMapping(value = "/user/login/{email}/password/{senha}")
    UserDataDTO getUser(@PathVariable("email")String email, @PathVariable("senha")String senha);

    @PostMapping(value = "/user/cadastro")
    UserPostDTO postUser(UserPostDTO userPostDTO);

}
