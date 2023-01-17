package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PopularityUtility {
    protected void manhwaProfileDtoBuilder(List<ManhwaProfileDTO> topFiveManhwaToday, Long comicId, ManhwaProfileRepository manhwaProfileRepository) {
        ManhwaProfile manhwaProfileById = manhwaProfileRepository.getManhwaProfileById(comicId);
        String title = manhwaProfileById.getTitle();
        Integer numberOfChapters = manhwaProfileById.getNumberOfChapters();
        Float rating = manhwaProfileById.getRating();
        String coverPageLink = manhwaProfileById.getCoverPageLink();
        topFiveManhwaToday.add(new ManhwaProfileDTO(comicId, title, coverPageLink, rating, numberOfChapters));
    }
}
