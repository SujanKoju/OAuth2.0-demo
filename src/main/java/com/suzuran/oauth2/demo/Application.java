package com.suzuran.oauth2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("api/v1/test")
    String test() {
        UserHelper principal = (UserHelper) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.toString());
        return "Test Success";
    }
}
