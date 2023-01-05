package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ManhwaProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ManhwaProfileController {

    private final ManhwaProfileService manhwaProfileService;
    private final GenreService genreService;

    @GetMapping(value = "/{manhwaName}")
    public ManhwaProfile getManhwa(@PathVariable String manhwaName){
        return manhwaProfileService.getManhwaProfileByName(manhwaName);
    }

    @GetMapping(value = "/{manhwaName}/views")
    public Integer getManhwaViewNumbers(@PathVariable String manhwaName){
        return null;
    }

    @GetMapping(value = "/{manhwaName}/genres")
    public List<String> getManhwaGenres(@PathVariable String manhwaName){
        manhwaName = "Murim Login";
        return genreService.getManhwaGenres(manhwaProfileService.getManhwaProfileByName(manhwaName).getId().intValue());
    }

    @GetMapping(value = "/{manhwaName}/themes")
    public List<String> getManhwaThemes(@PathVariable String manhwaName){
        return null;
    }

    @GetMapping(value = "/{manhwaName}/rating")
    public Float getMnahwaRating(@PathVariable String manhwaName){
        manhwaName = "Murim Login";
        return manhwaProfileService.getManhwaRating(manhwaName);
    }

}
