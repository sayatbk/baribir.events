package com.baribir.events.controller;

import com.baribir.events.dto.EventDto;
import com.baribir.events.dto.UserDto;
import com.baribir.events.entity.Event;
import com.baribir.events.entity.User;
import com.baribir.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService service;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event eventDto) {
        return ResponseEntity.ok(service.save(eventDto));
    }

    @GetMapping("/category/{category}/date/{date}")
    public ResponseEntity<?> getAllEventsByDate(@PathVariable String date, @PathVariable String category) {
        return ResponseEntity.ok(service.findByCategoryAndDate(date, category));
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
    public ResponseEntity<?> searchEvents(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(service.getEventsByParams(params));
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopular(){
        return ResponseEntity.ok(service.getPopular());
    }

    @GetMapping("/{eventId}/users")
    public ResponseEntity<?> getEventUsers(@PathVariable UUID eventId) {
        List<UserDto> users = service.getEventUsers(eventId);
        return ResponseEntity.ok(users);
    }
}
