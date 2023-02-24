package com.codecool.manhwalabbackend.model.DTO;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataForBookmarksDTO {
    private String username;
    private ComicProfile comicProfile;
    private UserProfile userProfile;
}
