package com.codecool.manhwalabbackend.model.DTO;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.model.Genre;
import com.codecool.manhwalabbackend.model.Theme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDTO {

    ComicProfile currentComic;
    List<ComicProfile> allOtherComics;
    List<Genre> allGenresForCurrentComic;
    List<Theme> allThemesForCurrentComic;
}
