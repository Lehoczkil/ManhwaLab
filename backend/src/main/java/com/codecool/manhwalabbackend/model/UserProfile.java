package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.Enums.Gender;
import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    @Column(columnDefinition = "TEXT")
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

