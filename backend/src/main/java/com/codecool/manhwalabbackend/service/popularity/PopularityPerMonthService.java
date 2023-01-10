package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.repository.popularity.PopularityPerMonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopularityPerMonthService {

    private PopularityPerMonthRepository popularityPerMonthRepository;

    public void refreshDataBase(Long id){
        popularityPerMonthRepository.nullifyData(id);
    }
}
