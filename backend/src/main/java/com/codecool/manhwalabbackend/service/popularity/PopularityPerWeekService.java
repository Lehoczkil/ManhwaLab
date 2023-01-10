package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.repository.popularity.PopularityPerWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopularityPerWeekService {

    private PopularityPerWeekRepository popularityPerWeekRepository;

    public void refreshDataBase(Long id){
        popularityPerWeekRepository.nullifyData(id);
    }
}
