package com.adn.web.service;

import com.adn.web.dto.ClubDto;
import com.adn.web.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club save(ClubDto clubDto);

    ClubDto findClubById(Integer clubId);

    void updateClub(ClubDto clubDto);

    void deleteClub(Integer clubId);
}
