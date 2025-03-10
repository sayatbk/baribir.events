package com.baribir.events.service;

import com.baribir.events.dto.UserPhotoDto;
import com.baribir.events.entity.UserPhoto;

import java.util.List;
import java.util.UUID;

public interface UserPhotoService {
    List<UserPhotoDto> getAll(UUID userId);
    boolean saveAll(List<UserPhotoDto> photos, UUID userId);
    UUID setAsMain(UUID main, UUID userId);
    UUID setAsMain(UserPhotoDto main, UUID userId);
    boolean delete(UUID id);
    UserPhoto save(UserPhotoDto photo, UUID userId);
}
