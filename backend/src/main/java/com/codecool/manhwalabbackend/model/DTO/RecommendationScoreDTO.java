package com.codecool.manhwalabbackend.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationScoreDTO {
    private String title;
    private int score;
}
