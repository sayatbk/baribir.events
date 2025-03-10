package com.baribir.events.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
    List<String> interestList;
    String username;
    String phoneNumber;
    String linkTelegram;
    String linkInstagram;
    String linkWhatsapp;
}
