package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
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
@CrossOrigin({"http://localhost:8081"})
public class TopManhwaController {

    private final PopularityService popularityService;

    @GetMapping(value = "/top/daily")
    public List<ManhwaProfileDTO> getTopDaily(){
        return popularityService.getDailyTopFiveComic();
    }

    @GetMapping(value = "/top/weekly")
    public List<ManhwaProfileDTO> getTopWeekly(){
        return popularityService.getWeeklyTopFiveComic();
    }

    @GetMapping(value = "/top/monthly")
    public List<ManhwaProfileDTO> getTopMonthly(){
        return popularityService.getMonthlyTopFiveComic();
    }
}
