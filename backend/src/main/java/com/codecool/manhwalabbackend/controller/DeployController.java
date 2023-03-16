package com.codecool.manhwalabbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class DeployController {

    @GetMapping(value = "/")
    public String getMainPage(){
        return "index.html";
    }
}
