package com.baribir.events.controller;

import com.baribir.events.dto.EventDto;
import com.baribir.events.entity.Event;
import com.baribir.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService service;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event eventDto) {
        return ResponseEntity.ok(service.save(eventDto));
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event eventDto) {
        return ResponseEntity.ok(service.save(eventDto));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable UUID id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEvents(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String date,
                                       @RequestParam(required = false) String location) {
        return ResponseEntity.ok(service.getEventsByParams(name, date, location));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getEventById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(service.findByCategory(categoryId));
    }
}
