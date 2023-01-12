package com.codecool.manhwalabbackend.model.popularity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComicPopularityPerDay {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private Long comicId;
    private Integer viewsThisDay;
}

