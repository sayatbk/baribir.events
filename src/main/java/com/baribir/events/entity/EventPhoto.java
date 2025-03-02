package com.baribir.events.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "event_photos")
public class EventPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "is_main")
    private Boolean isMain;

}
