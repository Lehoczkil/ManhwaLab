package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ComicProfileDTO;
import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PopularityUtility {
    protected void comicProfileDtoBuilder(List<ComicProfileDTO> topFiveComicToday, Long comicId, ComicProfileRepository comicProfileRepository) {
        ComicProfile comicProfileById = comicProfileRepository.getComicProfileById(comicId);
        String title = comicProfileById.getTitle();
        Integer numberOfChapters = comicProfileById.getNumberOfChapters();
        Float rating = comicProfileById.getRating();
        String coverPage = comicProfileById.getCoverPage();
        topFiveComicToday.add(new ComicProfileDTO(comicId, title, coverPage, rating, numberOfChapters));
    }
}
