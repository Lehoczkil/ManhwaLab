package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.TitleDTO;
import com.codecool.manhwalabbackend.model.DTO.UpdateUserDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/manhwaLab")
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8080", "http://localhost:8081", "http://manhwalab-static.s3-website.eu-central-1.amazonaws.com/"})
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping(value = "/profile")
    public UserProfile getUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userProfileService.getUser(username);
    }

    @PatchMapping(value = "/updateUser")
    public void updateUser(@RequestBody UpdateUserDTO userData) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        userProfileService.updateUser(username, userData);
    }

    @PutMapping(value = "addToReading")
    public void addToReading(@RequestBody TitleDTO titleDTO) {
        userProfileService.addToReading(titleDTO.getTitle());
    }

    @PutMapping(value = "addToReadLater")
    public void addToReadLater(@RequestBody TitleDTO titleDTO) {
        userProfileService.addToReadLater(titleDTO.getTitle());
    }

    @PutMapping(value = "addToFinished")
    public void addToFinished(@RequestBody TitleDTO titleDTO) {
        userProfileService.addToFinished(titleDTO.getTitle());
    }

    @PutMapping(value = "addToFavourites")
    public void addToFavourites(@RequestBody TitleDTO titleDTO) {
        userProfileService.addToFavourites(titleDTO.getTitle());
    }

    @DeleteMapping(value = "removeFromReading")
    public void removeFromReading(@RequestBody TitleDTO titleDTO) {
        userProfileService.removeFromReading(titleDTO.getTitle());
    }

    @DeleteMapping(value = "removeFromReadLater")
    public void removeFromReadLater(@RequestBody TitleDTO titleDTO) {
        userProfileService.removeFromReadLater(titleDTO.getTitle());
    }

    @DeleteMapping(value = "removeFromFinished")
    public void removeFromFinished(@RequestBody TitleDTO titleDTO) {
        userProfileService.removeFromFinished(titleDTO.getTitle());
    }

    @DeleteMapping(value = "removeFromFavourites")
    public void removeFromFavourites(@RequestBody TitleDTO titleDTO) {
        userProfileService.removeFromFavourites(titleDTO.getTitle());
    }
}
