package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.enums.Status;
import com.codecool.manhwalabbackend.model.enums.ComicType;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManhwaID")
    @SequenceGenerator(name = "ManhwaID", sequenceName = "ManhwaID", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
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
    @ManyToMany
    private List<UserProfile> userProfileID;
    @ManyToMany
    private List<Genre> genreList;
    @ManyToMany
    private List<Theme> themeList;
//    image?
}
