package com.codecool.manhwalabbackend.service.recommendations;

import com.codecool.manhwalabbackend.model.DTO.RecommendationScoreDTO;

import java.util.Comparator;

public class RecommendationScoreComparator implements Comparator<RecommendationScoreDTO> {


    @Override
    public int compare(RecommendationScoreDTO o1, RecommendationScoreDTO o2) {
        return o2.getScore()-o1.getScore();
    }
}
