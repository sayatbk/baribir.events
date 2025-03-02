package com.baribir.events.service;

import com.baribir.events.entity.Memory;

import java.util.List;
import java.util.UUID;

public interface MemoryService {
    List<Memory> getByUser(UUID user);
    List<Memory> getByUserPublic(UUID user);
    Memory save(Memory memory);
    void delete(UUID id);
    Memory getById(UUID id);

}
