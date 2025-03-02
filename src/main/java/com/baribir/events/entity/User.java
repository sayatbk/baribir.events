package com.baribir.events.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "username", length = Integer.MAX_VALUE)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "middle_name", length = Integer.MAX_VALUE)
    private String middleName;

    @Column(name = "phone_number", length = Integer.MAX_VALUE)
    private String phoneNumber;

    @Column(name = "link_telegram", length = Integer.MAX_VALUE)
    private String linkTelegram;

    @Column(name = "link_instagram", length = Integer.MAX_VALUE)
    private String linkInstagram;

    @Column(name = "link_whatsapp", length = Integer.MAX_VALUE)
    private String linkWhatsapp;

    @OneToMany(mappedBy = "user")
    private Set<UserPhoto> userPhotos = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "profile_photo_id")
    private UserPhoto profilePhoto;

}
