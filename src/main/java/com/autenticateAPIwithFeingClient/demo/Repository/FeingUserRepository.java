/* package com.autenticateAPIwithFeingClient.demo.Repository;

import com.autenticateAPIwithFeingClient.demo.DTO.UserDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "User", url = "localhost:8082")
public interface FeingUserRepository {

    @GetMapping(value = "/user/login/{email}/password/{senha}")
    UserDataDTO getLoginUser(@PathVariable("email")String email, @PathVariable("senha")String senha);

}

 */
