package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manhwaLab")
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8081", "https://manhwalab.onrender.com/"})
public class UserProfileController {

    private final UserProfileService userProfileService;
}
