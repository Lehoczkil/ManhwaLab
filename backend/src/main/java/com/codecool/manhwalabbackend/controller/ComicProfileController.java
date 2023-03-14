package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ComicProfileService;
import com.codecool.manhwalabbackend.service.popularity.PopularityService;
import com.codecool.manhwalabbackend.service.recommendations.ComicRecommendationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081", "http://manhwalab-static.s3-website.eu-central-1.amazonaws.com/"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ComicProfileController {

    private final ComicProfileService comicProfileService;
    private final GenreService genreService;
    private final PopularityService popularityService;
    private final ComicRecommendationsService recommendationsService;

    @GetMapping(value = "/{comicTitle}")
    public ComicProfile getComic(@PathVariable String comicTitle) {
        return comicProfileService.getComicProfileByName(comicTitle);
    }

    @PostMapping(value = "/update-view/{comicId}")
    public ResponseEntity<String> updateComicViewNumbers(@PathVariable Long comicId) {
        comicProfileService.updateComicViews(comicId);
        popularityService.updateDailyViewForComic(comicId, LocalDate.now());
        recommendationsService.getRecommendedComics(comicId);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{comicId}/recommendations")
    public List<ComicProfile> getComicRecommendationsById(@PathVariable Long comicId) {
        return recommendationsService.getRecommendedComics(comicId);
    }

}
