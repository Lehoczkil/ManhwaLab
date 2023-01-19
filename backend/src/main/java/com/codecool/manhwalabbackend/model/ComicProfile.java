package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.enums.Status;
import com.codecool.manhwalabbackend.model.enums.ComicType;
import lombok.*;
import javax.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComicProfile {
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
    private LocalDate released;
    private LocalDate updated;
    private String author;
    private Integer views;
    private Integer favourite;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> userProfile;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genreForComic",
                joinColumns = @JoinColumn(name = "comicProfileId"),
                inverseJoinColumns = @JoinColumn(name = "genreId"))
    private List<Genre> genreList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "themeForComic",
            joinColumns = @JoinColumn(name = "comicProfileId"),
            inverseJoinColumns = @JoinColumn(name = "themeId"))
    private List<Theme> themeList;
    private Float rating;
    private Integer ratingRanking;
    private Integer popularityRanking;
    private String coverPageLink;
}
