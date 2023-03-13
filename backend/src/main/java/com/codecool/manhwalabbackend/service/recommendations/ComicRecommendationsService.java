package com.codecool.manhwalabbackend.service.recommendations;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.model.DTO.RecommendationDTO;
import com.codecool.manhwalabbackend.model.DTO.RecommendationScoreDTO;
import com.codecool.manhwalabbackend.model.Genre;
import com.codecool.manhwalabbackend.model.Theme;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import com.codecool.manhwalabbackend.repository.GenreRepository;
import com.codecool.manhwalabbackend.service.ComicProfileService;
import com.codecool.manhwalabbackend.service.GenreService;
import com.codecool.manhwalabbackend.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComicRecommendationsService {

    private final GenreService genreService;
    private final ThemeService themeService;
    //    private final ComicProfileRepository comicProfileRepository;
    private final ComicProfileService comicProfileService;

    public List<ComicProfile> getRecommendedComics(Long id) {
        RecommendationDTO recommendationDTO = createRecommendationDTO(id);
        List<RecommendationScoreDTO> recommendationScoreDTOList = new ArrayList<>();
        for (ComicProfile currentlyCalculatedComic : recommendationDTO.getAllOtherComics()) {
            int currentScore = calculateRecommendationValue(currentlyCalculatedComic, recommendationDTO);
            recommendationScoreDTOList.add(new RecommendationScoreDTO(currentlyCalculatedComic.getTitle(), currentScore));
        }

        return getTopFiveComicProfile(recommendationScoreDTOList);
    }

    private RecommendationDTO createRecommendationDTO(Long id) {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setCurrentComic(getCurrentComic(id));
        recommendationDTO.setAllOtherComics(getAllOtherComics(id));
        recommendationDTO.setAllThemesForCurrentComic(getSearchedComicProfileThemes(id));
        recommendationDTO.setAllGenresForCurrentComic(getSearchedComicProfileGenres(id));
        return recommendationDTO;
    }

    private List<Genre> getSearchedComicProfileGenres(Long id) {
        return genreService.getComicGenres(id);
    }

    private List<Theme> getSearchedComicProfileThemes(Long id) {
        return themeService.getComicThemes(id);
    }

    private int calculateRecommendationValue(ComicProfile currentlyCalculatedComic, RecommendationDTO recommendationDTO) {
        int recommendationValue = 0;
        for (Genre genre : currentlyCalculatedComic.getGenreList()) {
            for (Genre currentComicGenre : recommendationDTO.getCurrentComic().getGenreList()) {
                if (currentComicGenre.getName().equals(genre.getName())) {
                    recommendationValue += 25;
                    System.out.println(recommendationValue + "||" + currentlyCalculatedComic.getTitle());
                    break;
                }
            }
        }

        for (Theme theme : currentlyCalculatedComic.getThemeList()) {
            for (Theme currentComicTheme : recommendationDTO.getCurrentComic().getThemeList()) {
                if (currentComicTheme.getName().equals(theme.getName())) {
                    recommendationValue += 15;
                    break;
                }
            }
        }
        return (int) (recommendationValue + currentlyCalculatedComic.getRating() * 10);
    }

    private List<ComicProfile> getTopFiveComicProfile(List<RecommendationScoreDTO> recommendationScoreDTOList) {
        RecommendationScoreComparator comparator = new RecommendationScoreComparator();
        recommendationScoreDTOList.sort(comparator);
        recommendationScoreDTOList = recommendationScoreDTOList.stream().limit(5).collect(Collectors.toList());
        List<ComicProfile> recommendedComics = new ArrayList<>();
        for (RecommendationScoreDTO recommendationScoreDTO : recommendationScoreDTOList) {
            recommendedComics.add(comicProfileService.getComicProfileByName(recommendationScoreDTO.getTitle()));
        }
        return recommendedComics;
    }

    private List<ComicProfile> getAllOtherComics(Long id) {
        return comicProfileService.getAllOtherComicProfile(id);
    }

    private ComicProfile getCurrentComic(Long id) {
        return comicProfileService.getComicProfileById(id);
    }
}
