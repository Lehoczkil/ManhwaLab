package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.enums.Gender;
import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProfileID")
    @SequenceGenerator(name = "ProfileID", sequenceName = "ProfileID", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private String description;
    private Integer age;
    private String Password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;
    private Timestamp lastOnline;
    private Timestamp joined;
//    profile picture

}

