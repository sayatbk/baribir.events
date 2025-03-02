package com.baribir.events.service;

import com.baribir.events.entity.Interest;

public interface InterestService {
    Interest save(Interest interest);
    Interest findById(Long id);
    void deleteById(Long id);
    Iterable<Interest> findAll();
    long count();
    Interest findByName(String name);
}
