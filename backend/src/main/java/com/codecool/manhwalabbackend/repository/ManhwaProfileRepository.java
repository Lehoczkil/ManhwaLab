package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManhwaProfileRepository extends JpaRepository<ManhwaProfile, Long> {

    ManhwaProfile getManhwaProfileByName(String name);
}

