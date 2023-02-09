package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile getUserProfileByUsername(String username);

}

