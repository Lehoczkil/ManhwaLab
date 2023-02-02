package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.UserProfileDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8081", "https://manhwalab.onrender.com/"})
@RequestMapping("/api/manhwaLab")
public class UserManagementController {

    private final UserProfileService userProfileService;

    @PostMapping("/registration")
    public void newUserRegistration(@RequestBody UserProfileDTO userData) {
        userProfileService.addNewUser(userData);
    }

}
