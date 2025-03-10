package com.baribir.events.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link com.baribir.events.entity.UserPhoto}
 */
@RequiredArgsConstructor
public class UserPhotoDto implements Serializable {
    String name;
    UUID userId;
    byte[] data;
    Instant createdAt;
    Boolean isMain;

}
