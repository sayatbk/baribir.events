package com.baribir.events.service;

import com.baribir.events.dto.JwtAuthenticationDto;
import com.baribir.events.dto.RefreshTokenDto;
import com.baribir.events.dto.UserCredentialsDto;
import com.baribir.events.dto.UserDto;
import com.baribir.events.entity.UserPhoto;
import org.springframework.data.crossstore.ChangeSetPersister;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.UUID;

public interface UserService {
    JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException;
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception;
    UserDto getUserById(String id) throws ChangeSetPersister.NotFoundException;
    UserDto getUserByEmail(String email) throws ChangeSetPersister.NotFoundException;
    String addUser(UserDto user);
    List<UserPhoto> getUserPhotosByUser(UUID userId, boolean isPublic);
}
