package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile getUserProfileByUsername(String username);

    @Query(value = "SELECT email FROM user_profile", nativeQuery = true)
    ArrayList<String> getUserEmails();

    @Query(value = "SELECT username FROM user_profile", nativeQuery = true)
    ArrayList<String> getUsernames();
}

