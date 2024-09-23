package com.adn.web.service;

import com.adn.web.dto.EventDto;
import com.adn.web.model.Event;
import com.adn.web.repository.ClubRepository;
import com.adn.web.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Integer clubId, EventDto eventDto) {
        eventRepository.save(mapToEvent(eventDto, clubId));
    }

    public Event mapToEvent(EventDto eventDto, Integer clubId) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setType(eventDto.getType());
        event.setPhotoUrl(eventDto.getPhotoUrl());
        event.setStartTime(eventDto.getStartTime());
        event.setEndTime(eventDto.getEndTime());
        event.setClub(clubRepository.findById(clubId).get());
        return event;
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .photoUrl(event.getPhotoUrl())
                .type(event.getType())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
    }
}
