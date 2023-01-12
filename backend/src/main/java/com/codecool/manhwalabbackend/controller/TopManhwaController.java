package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.service.popularity.PopularityPerDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/manhwaLab")
@RequiredArgsConstructor
public class TopManhwaController {

    @GetMapping(value = "/top/daily")
    public List<ManhwaProfileDTO> getTopDaily(){
        return null;
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