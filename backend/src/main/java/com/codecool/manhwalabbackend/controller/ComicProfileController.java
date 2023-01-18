package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ComicProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ComicProfileController {

    private final ComicProfileService comicProfileService;
    private final GenreService genreService;

    @GetMapping(value = "/{comicTitle}")
    public ComicProfile getComic(@PathVariable String comicTitle) {
        return comicProfileService.getComicProfileByName(comicTitle);
    }

    @GetMapping(value = "/{comicTitle}/views")
    public Integer getComicViewNumbers(@PathVariable String comicTitle){
        return null;
    }

    @GetMapping(value = "/{comicTitle}/genres")
    public List<String> getComicGenres(@PathVariable String comicTitle){
        return genreService.getComicGenres(comicProfileService.getComicProfileByName(comicTitle).getId().intValue());
    }

    @GetMapping(value = "/{comicTitle}/themes")
    public List<String> getComicThemes(@PathVariable String comicTitle){
        return null;
    }

    @GetMapping(value = "/{comicTitle}/rating")
    public Float getComicRating(@PathVariable String comicTitle){
        return comicProfileService.getComicRating(comicTitle);
    }

}
