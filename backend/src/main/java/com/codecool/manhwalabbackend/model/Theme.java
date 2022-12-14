package com.codecool.manhwalabbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ThemeID")
    @SequenceGenerator(name = "ThemeID", sequenceName = "ThemeID", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

}
