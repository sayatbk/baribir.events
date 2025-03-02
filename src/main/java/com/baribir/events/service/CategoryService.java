package com.baribir.events.service;

import com.baribir.events.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Long id);
    Category save(Category category);
    boolean deleteById(Long id);
}
