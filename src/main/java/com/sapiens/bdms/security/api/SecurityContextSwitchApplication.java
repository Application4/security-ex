package com.sapiens.bdms.security.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/rest")
public class SecurityContextSwitchApplication {

    @GetMapping("/welcome")
    public String welcome() {
        return "Security Works for multiple Entry Point !";
    }

    @GetMapping("/hello")
    public String hello() {
        return "working !!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityContextSwitchApplication.class, args);
    }

}
