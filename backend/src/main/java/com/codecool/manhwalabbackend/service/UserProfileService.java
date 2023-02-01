package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public void addNewUser(UserProfile userProfile){
        userProfileRepository.save(userProfile);
    }
}

