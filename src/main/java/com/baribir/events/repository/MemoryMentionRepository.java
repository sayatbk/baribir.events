package com.baribir.events.repository;

import com.baribir.events.entity.MemoryMention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemoryMentionRepository extends JpaRepository<MemoryMention, UUID> {
}
