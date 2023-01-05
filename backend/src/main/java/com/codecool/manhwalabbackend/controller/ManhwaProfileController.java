package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ManhwaProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ManhwaProfileController {

    private final ManhwaProfileService manhwaProfileService;
    private final GenreService genreService;

    @GetMapping(value = "/{id}")
    public ManhwaProfile getManhwa(@PathVariable Long id){
        return manhwaProfileService.getManhwaProfileById(id);
    }

    @GetMapping(value = "/{manhwaId}/views")
    public Integer getManhwaViewNumbers(@PathVariable Long manhwaId){
        return null;
    }

    @GetMapping(value = "/{manhwaId}/genres")
    public List<String> getManhwaGenres(@PathVariable Long manhwaId){
        return genreService.getManhwaGenres(manhwaId.intValue());
    }

    @GetMapping(value = "/{manhwaId}/themes")
    public List<String> getManhwaThemes(@PathVariable Long manhwaId){
        return null;
    }

    @GetMapping(value = "/{manhwaId}/rating")
    public Float getMnahwaRating(@PathVariable Long manhwaId){
        return null;
    }

}
