package com.codecool.manhwalabbackend.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComicProfileDTO {

    private Long comicId;
    private String title;
    private String coverPageSmall;
    private Float rating;
    private Integer numberOfChapters;
}
