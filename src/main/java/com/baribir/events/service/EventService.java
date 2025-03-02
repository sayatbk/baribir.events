package com.baribir.events.service;

import com.baribir.events.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEvents();
    Event getEventById(Long id);
    Event saveEvent(Event event);
    void deleteEvent(Long id);
//    List<Event> getEventsByDate(String date);
//    List<Event> getEventsByCategory(String category);
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
