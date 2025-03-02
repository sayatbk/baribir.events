package com.baribir.events.repository;

import com.baribir.events.entity.EventPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventPhotoRepository extends JpaRepository<EventPhoto, UUID> {
}
