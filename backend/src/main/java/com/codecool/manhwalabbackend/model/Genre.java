package com.codecool.manhwalabbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GenreID")
    @SequenceGenerator(name = "GenreID", sequenceName = "GenreID", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

}
