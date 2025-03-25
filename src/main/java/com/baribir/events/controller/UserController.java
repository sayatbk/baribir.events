package com.baribir.events.controller;

import com.baribir.events.dto.UserDto;
import com.baribir.events.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public String createUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/event/{event}")
    public List<UserDto> getByEvent(@PathVariable UUID event) throws ChangeSetPersister.NotFoundException {
        return userService.getByEvent(event);
    }
}
