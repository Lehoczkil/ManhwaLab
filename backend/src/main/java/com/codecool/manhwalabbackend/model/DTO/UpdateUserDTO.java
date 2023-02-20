package com.codecool.manhwalabbackend.model.DTO;

import com.codecool.manhwalabbackend.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    private String username;
    private String age;
    private String gender;
    private String location;
    private String description;
}
