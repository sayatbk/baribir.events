package com.baribir.events.controller;

import com.baribir.events.service.UserPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user-photos")
@RequiredArgsConstructor
public class UserPhotoController {
    private final UserPhotoService userPhotoService;

}
