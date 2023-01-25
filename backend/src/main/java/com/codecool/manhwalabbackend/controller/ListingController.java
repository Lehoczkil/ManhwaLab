package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.enums.ComicType;
import com.codecool.manhwalabbackend.model.Genre;
import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.model.Theme;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ComicProfileService;
import com.codecool.manhwalabbackend.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081", "http://10.44.7.208:8081/"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class ListingController {

    private final ComicProfileService comicProfileService;
    private final GenreService genreService;
    private final ThemeService themeService;

    @GetMapping(value = "/manhwaList")
    public List<ComicProfile> getAllComic(){
        return comicProfileService.getAllComic();
    }

    @GetMapping(value = "/genres")
    public List<Genre> getAllGenre(){
        return genreService.getAllGenre();
    }

    @GetMapping(value = "/themes")
    public List<Theme> getAllTheme(){
        return themeService.getAllTheme();
    }

    @GetMapping(value = "/types")
    public List<ComicType> getAllType(){
        return new ArrayList<>(EnumSet.allOf(ComicType.class));
    }
 }
