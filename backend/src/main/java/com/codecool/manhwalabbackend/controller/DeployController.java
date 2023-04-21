package com.codecool.manhwalabbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class DeployController {

    @GetMapping("comics")
    public String getComicsPage() {
        return "index.html";
    }

    @GetMapping("user-profile")
    public String getUserProfilePage() {
        return "index.html";
    }

    @GetMapping("comics/:id")
    public String getComicProfilePageForStatic(@PathVariable String id) {
        return "index.html";

    }
}
