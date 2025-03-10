package com.baribir.events.repository;

import com.baribir.events.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, UUID> {
}
