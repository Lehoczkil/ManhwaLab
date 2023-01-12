package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.service.popularity.PopularityPerDayService;
import com.codecool.manhwalabbackend.service.popularity.PopularityPerMonthService;
import com.codecool.manhwalabbackend.service.popularity.PopularityPerWeekService;
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

    private final PopularityPerDayService popularityPerDayService;
    private final PopularityPerWeekService popularityPerWeekService;
    private final PopularityPerMonthService popularityPerMonthService;

    @GetMapping(value = "/top/daily")
    public List<ManhwaProfileDTO> getTopDaily(){
        return popularityPerDayService.getTopFiveDailyComic();
    }

    @GetMapping(value = "/top/weekly")
    public List<ManhwaProfile> getTopWeekly(){
        return null;
    }

    @GetMapping(value = "/top/monthly")
    public List<ManhwaProfile> getTopMonthly(){
        return null;
    }
}
