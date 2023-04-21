package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.DTO.UserProfileDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
@RequiredArgsConstructor
@CrossOrigin({"http://localhost:8080", "http://localhost:8081"})
@RequestMapping("/api/manhwaLab")
public class UserManagementController {

    private final UserProfileService userProfileService;

    @PostMapping("/registration")
    public ResponseEntity newUserRegistration(@RequestBody UserProfileDTO userData) {
        UserProfile user = userProfileService.addNewUser(userData);
        if (user == null) {
            return new ResponseEntity(HttpStatus.SEE_OTHER);
        } else {
            return  new ResponseEntity(HttpStatus.CREATED);
        }
    }

}
