package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.Enums.Status;
import com.codecool.manhwalabbackend.model.Enums.ComicType;
import lombok.*;
import javax.persistence.*;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManhwaProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private ComicType type;
    private Integer numberOfChapters;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Timestamp released;
    private Timestamp updated;
    private String author;
    private Integer views;
    private Integer favourite;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> userProfile;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Genre> genreList;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Theme> themeList;
    private Float rating;
    private Integer ratingRanking;
    private Integer popularityRanking;
    private String coverPageLink;
}
