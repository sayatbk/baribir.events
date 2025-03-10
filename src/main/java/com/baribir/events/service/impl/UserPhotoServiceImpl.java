package com.baribir.events.service.impl;

import com.baribir.events.dto.UserPhotoDto;
import com.baribir.events.entity.UserPhoto;
import com.baribir.events.mapper.UserPhotoMapper;
import com.baribir.events.repository.UserPhotoRepository;
import com.baribir.events.repository.UserRepository;
import com.baribir.events.service.UserPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserPhotoServiceImpl implements UserPhotoService {
    private final UserPhotoRepository repository;
    private final UserPhotoMapper mapper;
    private final UserRepository userRepository;

    @Override
    public List<UserPhotoDto> getAll(UUID userId) {
        return mapper.toDto(repository.findByUser_Id(userId));
    }

    @Override
    public boolean saveAll(List<UserPhotoDto> photos, UUID userId) {
        return !mapper.toDto(
                repository.saveAll(mapper.toEntity(photos)))
                .isEmpty();
    }

    @Override
    public UUID setAsMain(UUID main, UUID userId) {
        repository.updateIsMainByUserId(userId);
        repository.updateIsMainById(true, main);
        return repository.findByUser_IdAndIsMainTrue(userId).getId();
    }

    @Override
    public UUID setAsMain(UserPhotoDto main, UUID userId) {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public UserPhoto save(UserPhotoDto photo, UUID userId) {
        UserPhoto entity = mapper.toEntity(photo);
        entity.setUser(userRepository.getReferenceById(userId));

        return repository.save(entity);
    }
}
