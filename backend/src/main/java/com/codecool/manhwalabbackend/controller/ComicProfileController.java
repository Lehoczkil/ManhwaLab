package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ComicProfileService;
import com.codecool.manhwalabbackend.service.popularity.PopularityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081", "https://manhwalab.onrender.com/"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ComicProfileController {

    private final ComicProfileService comicProfileService;
    private final GenreService genreService;
    private final PopularityService popularityService;

    @GetMapping(value = "/{comicTitle}")
    public ComicProfile getComic(@PathVariable String comicTitle) {
        return comicProfileService.getComicProfileByName(comicTitle);
    }

    @PostMapping(value = "/{comicId}/update-view")
    public ResponseEntity<String> updateComicViewNumbers(@PathVariable Long comicId){
        comicProfileService.updateComicViews(comicId);
        popularityService.updateDailyViewForComic(comicId, LocalDate.now());
        return new ResponseEntity<>("Succes", HttpStatus.CREATED);

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
