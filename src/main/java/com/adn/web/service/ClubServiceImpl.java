package com.adn.web.service;

import com.adn.web.dto.ClubDto;
import com.adn.web.model.Club;
import com.adn.web.repository.ClubRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public Club save(ClubDto clubDto) {
        Club club = newMapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Integer clubId) {
        Optional<Club> club = clubRepository.findById(clubId);
        try {
            return mapToClubDto(club.get());
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Optional<Club> club = clubRepository.findById(clubDto.getId());
        club.ifPresent(value -> clubRepository.save(mapToClub(value, clubDto)));
    }

    @Override
    public void deleteClub(Integer clubId) {
        clubRepository.deleteById(clubId);
    }

    public Club mapToClub(Club club, ClubDto clubDto) {
        club.setTitle(clubDto.getTitle());
        club.setPhotoUrl(clubDto.getPhotoUrl());
        club.setContent(clubDto.getContent());
        return club;
    }

    public ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(event -> EventServiceImpl.mapToEventDto(event)).toList())
                .build();
    }

    public Club newMapToClub(ClubDto clubDto) {
        return Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .photoUrl(clubDto.getPhotoUrl())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
    }
}
