package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComicProfileService {

    private final ComicProfileRepository comicProfileRepository;

    public ComicProfile getComicProfileByName(String title){
        return comicProfileRepository.getComicProfileByTitle(title);
    }

    public Float getComicRating(String title){
        return comicProfileRepository.getComicProfileRatingByTitle(title);
    }

    public List<ComicProfile> getAllComic(){
        return comicProfileRepository.findAll();
    }

}

