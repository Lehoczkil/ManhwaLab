package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.UpdateUserDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/manhwaLab")
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8081", "https://manhwalab.onrender.com/"})
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

}
