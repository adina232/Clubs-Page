package com.adn.web.service;

import com.adn.web.dto.EventDto;

public interface EventService {
    void createEvent(Integer clubId, EventDto eventDto);
}
