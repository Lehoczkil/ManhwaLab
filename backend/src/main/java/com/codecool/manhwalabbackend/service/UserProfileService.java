package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.DTO.UpdateUserDTO;
import com.codecool.manhwalabbackend.model.DTO.UserProfileDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.model.enums.Gender;
import com.codecool.manhwalabbackend.model.roles.ApplicationUserRoles;
import com.codecool.manhwalabbackend.repository.UserProfileRepository;
import com.codecool.manhwalabbackend.security.PasswordConfig;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class UserProfileService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordConfig passwordConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userProfileRepository.getUserProfileByUsername(username);
    }

    public UserProfile getUser(String username){
        return userProfileRepository.getUserProfileByUsername(username);    }

    public void addNewUser(UserProfileDTO userProfileDTO){
        userProfileDTO.setRole(ApplicationUserRoles.USER);
        UserProfile userProfile = userProfileBuilder(userProfileDTO);
        userProfileRepository.save(userProfile);
    }

    private UserProfile userProfileBuilder(UserProfileDTO userProfileDTO){
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(userProfileDTO.getUsername());
        userProfile.setPassword(passwordConfig.passwordEncoder().encode(userProfileDTO.getPassword()));
        userProfile.setEmail(userProfileDTO.getEmail());
        userProfile.setRole(userProfileDTO.getRole());
        return userProfile;
    }

    public void updateUser(String username, UpdateUserDTO updateUserDTO) {
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        userProfile.setUsername(updateUserDTO.getUsername());
        userProfile.setAge(Integer.valueOf(updateUserDTO.getAge()));
        userProfile.setGender(Gender.valueOf(updateUserDTO.getGender()));
        userProfile.setLocation(updateUserDTO.getLocation());
        userProfile.setDescription(updateUserDTO.getDescription());
        userProfileRepository.save(userProfile);
    }

}

