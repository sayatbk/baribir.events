package com.baribir.events.service.impl;

import com.baribir.events.dto.EventDto;
import com.baribir.events.entity.Event;
import com.baribir.events.repository.EventRepository;
import com.baribir.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public List<Event> getEvents() {
        return List.of();
    }

    @Override
    public Event getById(Long id) {
        return null;
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Event> getEventsByParams(String name, String date, String location) {
        return List.of();
    }

    @Override
    public List<Event> findByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }
}
