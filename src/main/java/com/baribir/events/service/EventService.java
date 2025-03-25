package com.baribir.events.service;

import com.baribir.events.dto.EventDto;
import com.baribir.events.dto.UserDto;
import com.baribir.events.entity.Event;
import com.baribir.events.entity.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface EventService {
    Event getById(UUID id);
    Event save(Event event);
    void delete(UUID id);
    List<Event> getEventsByParams(Map<String, String> params);
    List<Event> findByCategoryAndDate(String date, String category);

    List<Event> getPopular();

    List<UserDto> getEventUsers(UUID eventId);
//    List<Event> getEventsByDate(String date);
//    List<Event> getEventsByLocation(String location);
//    List<Event> getEventsByOrganizer(String organizer);
//    List<Event> getEventsBySpeaker(String speaker);
//    List<Event> getEventsByTag(String tag);
//    List<Event> searchEvents(String keyword);
//    List<Event> getEventsByPriceRange(double minPrice, double maxPrice);
//    List<Event> getEventsByPopularity();
//    List<Event> getEventsByRating();
//    List<Event> getEventByParams(Object parameter);
}
