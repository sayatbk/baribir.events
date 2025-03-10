package com.baribir.events.service;

import com.baribir.events.dto.EventDto;
import com.baribir.events.entity.Event;

import java.util.List;
import java.util.UUID;

public interface EventService {
    List<Event> getEvents();
    Event getById(Long id);
    Event save(Event event);
    void delete(UUID id);

    List<Event> getEventsByParams(String name, String date, String location);

    List<Event> findByCategory(Long categoryId);

    List<Event> findAll();
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
