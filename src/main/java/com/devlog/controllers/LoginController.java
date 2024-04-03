package com.devlog.controllers;

import com.devlog.security.Login;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@Slf4j
public class LoginController {

    private Login login;

    @PostMapping("/getCode")
    public String getCode(@RequestBody String code) throws URISyntaxException, IOException, InterruptedException {
        log.info("It got here");
        return login.getAccessToken(code);
    }
    @PostMapping("/user")
    public String getUser(@RequestBody String token) throws URISyntaxException, IOException, InterruptedException {
        log.info("gotto here");
       return login.getUserId(token);
    }

}
