package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.model.DTO.DataForBookmarksDTO;
import com.codecool.manhwalabbackend.model.DTO.UpdateUserDTO;
import com.codecool.manhwalabbackend.model.DTO.UserProfileDTO;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.model.enums.Gender;
import com.codecool.manhwalabbackend.model.roles.ApplicationUserRoles;
import com.codecool.manhwalabbackend.repository.UserProfileRepository;
import com.codecool.manhwalabbackend.security.PasswordConfig;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor
@Transactional
public class UserProfileService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordConfig passwordConfig;
    private final ComicProfileService comicProfileService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userProfileRepository.getUserProfileByUsername(username);
    }

    public UserProfile getUser(String username) {
        return userProfileRepository.getUserProfileByUsername(username);
    }

    public UserProfile addNewUser(UserProfileDTO userProfileDTO) {
        ArrayList<String> emails = userProfileRepository.getUserEmails();
        ArrayList<String> usernames = userProfileRepository.getUsernames();
        if (emails.contains(userProfileDTO.getEmail()) || usernames.contains(userProfileDTO.getUsername())) {
            return null;
        }
        userProfileDTO.setRole(ApplicationUserRoles.USER);
        UserProfile userProfile = userProfileBuilder(userProfileDTO);
        userProfileRepository.save(userProfile);
        return userProfile;
    }

    private UserProfile userProfileBuilder(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(userProfileDTO.getUsername());
        userProfile.setPassword(passwordConfig.passwordEncoder().encode(userProfileDTO.getPassword()));
        userProfile.setEmail(userProfileDTO.getEmail());
        userProfile.setRole(userProfileDTO.getRole());
        return userProfile;
    }

    //    ne legyen minden String és akkor nem kell valueOf-ozni :D
//    meg amúgy a save az csinál egy új user-t, so elvileg az nem editeli, hanem lement egy újat, bár idk mi van akkor ha kiszeded db-ből és utána save-eled, ha megnézted és megcsinálja akkor mind1, csak fura :D
    public void updateUser(String username, UpdateUserDTO updateUserDTO) {
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        userProfile.setUsername(updateUserDTO.getUsername());
        userProfile.setAge(Integer.valueOf(updateUserDTO.getAge()));
        userProfile.setGender(Gender.valueOf(updateUserDTO.getGender()));
        userProfile.setLocation(updateUserDTO.getLocation());
        userProfile.setDescription(updateUserDTO.getDescription());
    }
//    Innentől mindegyiknek első 3 sorát kilehet szervezni egy függvénybe, ami vissza ad egy objektumot
//    aminek van egy username, userProfile, comicProfile field-je, és azokat get-elni
    public void addToReading(String title) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        ComicProfile comicProfile = comicProfileService.getComicProfileByName(title);
        List<ComicProfile> newRead = userProfile.getRead();
        newRead.add(comicProfile);
        userProfile.setRead(newRead);
        userProfileRepository.save(userProfile);
    }

    public void addToReadLater(String title) {
        DataForBookmarksDTO data = getDataForAddComicsToBookmarks(title);
        List<ComicProfile> newReadLater = data.getUserProfile().getReadLater();
        newReadLater.add(data.getComicProfile());
        data.getUserProfile().setReadLater(newReadLater);
        userProfileRepository.save(data.getUserProfile());
    }

    public void addToFinished(String title) {
        DataForBookmarksDTO data = getDataForAddComicsToBookmarks(title);

        List<ComicProfile> newFinished = data.getUserProfile().getFinished();
        newFinished.add(data.getComicProfile());
        data.getUserProfile().setFinished(newFinished);
        userProfileRepository.save(data.getUserProfile());
    }

    public void addToFavourites(String title) {
        DataForBookmarksDTO data = getDataForAddComicsToBookmarks(title);
        List<ComicProfile> newFavourites = data.getUserProfile().getFavourites();
        newFavourites.add(data.getComicProfile());
        data.getUserProfile().setFavourites(newFavourites);
        userProfileRepository.save(data.getUserProfile());
    }

    private DataForBookmarksDTO getDataForAddComicsToBookmarks(String title){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        ComicProfile comicProfile = comicProfileService.getComicProfileByName(title);
        return new DataForBookmarksDTO(username, comicProfile, userProfile);
    }

    public void removeFromReading(String title) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        Long comicId = comicProfileService.getComicProfileByName(title).getId();
        List<ComicProfile> newReading = userProfile.getRead().stream().filter(item -> !item.getId().equals(comicId)).collect(Collectors.toList());
        userProfile.setRead(newReading);
        userProfileRepository.save(userProfile);
    }

    public void removeFromReadLater(String title) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        Long comicId = comicProfileService.getComicProfileByName(title).getId();
        List<ComicProfile> newReadLater = userProfile.getReadLater().stream().filter(item -> !item.getId().equals(comicId)).collect(Collectors.toList());
        userProfile.setReadLater(newReadLater);
        userProfileRepository.save(userProfile);
    }

    public void removeFromFinished(String title) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        Long comicId = comicProfileService.getComicProfileByName(title).getId();
        List<ComicProfile> newFinished = userProfile.getFinished().stream().filter(item -> !item.getId().equals(comicId)).collect(Collectors.toList());
        userProfile.setFinished(newFinished);
        userProfileRepository.save(userProfile);
    }

    public void removeFromFavourites(String title) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserProfile userProfile = userProfileRepository.getUserProfileByUsername(username);
        Long comicId = comicProfileService.getComicProfileByName(title).getId();
        List<ComicProfile> newFavourites = userProfile.getFavourites().stream().filter(item -> !item.getId().equals(comicId)).collect(Collectors.toList());
        userProfile.setFavourites(newFavourites);
        userProfileRepository.save(userProfile);
    }
}

