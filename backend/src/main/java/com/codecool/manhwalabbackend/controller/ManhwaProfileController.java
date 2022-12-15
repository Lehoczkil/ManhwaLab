package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manhwa")
public class ManhwaProfileController {


    @GetMapping(value = "/{manhwaName}")
    public ManhwaProfile getManhwa(@PathVariable String manhwaName){
        return null;
    }

    @GetMapping(value = "/{manhwaName}/views")
    public Integer getManhwaViewNumbers(@PathVariable String manhwaName){
        return null;
    }

    @GetMapping(value = "/{manhwaName}/genres")
    public List<String> getManhwaGenres(@PathVariable String manhwaName){
        return null;
    }

    @GetMapping(value = "/{manhwaName}/themes")
    public List<String> getManhwaThemes(@PathVariable String manhwaName){
        return null;
    }

}
