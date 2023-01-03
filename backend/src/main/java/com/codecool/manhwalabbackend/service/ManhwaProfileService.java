package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManhwaProfileService {

    ManhwaProfileRepository manhwaProfileRepository;

    @Autowired
    public ManhwaProfileService(ManhwaProfileRepository manhwaProfileRepository) {
        this.manhwaProfileRepository = manhwaProfileRepository;
    }

    public ManhwaProfile getManhwaProfileByName(String title){
        return manhwaProfileRepository.getManhwaProfileByTitle(title);
    }

    public Float getManhwaRating(String title){
        return manhwaProfileRepository.getManhwaProfileRatingByTitle(title);
    }

    public List<ManhwaProfile> getAllManhwa(){
        return manhwaProfileRepository.findAll();
    }

}

