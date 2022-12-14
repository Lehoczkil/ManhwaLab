package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManhwaProfileService {

    ManhwaProfileRepository manhwaProfileRepository;

    @Autowired
    public ManhwaProfileService(ManhwaProfileRepository manhwaProfileRepository) {
        this.manhwaProfileRepository = manhwaProfileRepository;
    }
}

