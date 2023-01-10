package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.repository.popularity.PopularityPerDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopularityPerDayService {

    private PopularityPerDayRepository popularityPerDayRepository;

    public void refreshDataBase(Long id){
        popularityPerDayRepository.nullifyData(id);
    }
}
