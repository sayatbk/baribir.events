package com.baribir.events.repository;

import com.baribir.events.entity.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPhotoRepository extends JpaRepository<UserPhoto, UUID> {
}
