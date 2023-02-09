package com.codecool.manhwalabbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig{
    //TODO : encode the password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();}
}
