package com.baribir.events.service.impl;

import com.baribir.events.dto.EventDto;
import com.baribir.events.dto.UserDto;
import com.baribir.events.entity.Category;
import com.baribir.events.entity.Event;
import com.baribir.events.entity.User;
import com.baribir.events.mapper.UserMapper;
import com.baribir.events.repository.CategoryRepository;
import com.baribir.events.repository.EventRepository;
import com.baribir.events.repository.UserRepository;
import com.baribir.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final CategoryRepository categoryRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Event getById(UUID id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Event> getEventsByParams(Map<String, String> params) {
        String dateStr = params.get("date");
        String categoryCode = params.get("category");
        String interestsStr = params.get("interests");

        LocalDate eventDate = (dateStr != null && !dateStr.isEmpty()) ? LocalDate.parse(dateStr) : null;
        List<Category> categories = (categoryCode != null && !categoryCode.isEmpty())
                ? categoryRepository.findByCodeWithChildren(categoryCode)
                : null;
        List<String> interests = (interestsStr != null && !interestsStr.isEmpty())
                ? Arrays.asList(interestsStr.split(","))
                : null;

        return repository.findEventsByParams(categories, interests, eventDate);
    }

    @Override
    public List<Event> findByCategoryAndDate(String date, String category) {
        LocalDate dateIso = LocalDate.parse(date);
        List<Category> cats = categoryRepository.findByCodeWithChildren(category);
        return repository.findByCategoryInAndDate(cats, dateIso);
    }

    @Override
    public List<Event> getPopular() {
        return repository.getPopular();
    }

    @Override
    public List<UserDto> getEventUsers(UUID eventId) {
        return userMapper.toDto(repository.findUsersByEvent(eventId));
    }
}
