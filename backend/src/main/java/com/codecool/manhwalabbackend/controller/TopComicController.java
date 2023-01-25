package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.ComicProfileDTO;
import com.codecool.manhwalabbackend.service.popularity.PopularityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/manhwaLab")
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8081", "http://10.44.7.208:8081/"})
public class TopComicController {

    private final PopularityService popularityService;

    @GetMapping(value = "/top/daily")
    public List<ComicProfileDTO> getTopDaily(){
        return popularityService.getDailyTopFiveComic();
    }

    @GetMapping(value = "/top/weekly")
    public List<ComicProfileDTO> getTopWeekly(){
        return popularityService.getWeeklyTopFiveComic();
    }

    @GetMapping(value = "/top/monthly")
    public List<ComicProfileDTO> getTopMonthly(){
        return popularityService.getMonthlyTopFiveComic();
    }
}
