package com.baribir.events.mapper;

import com.baribir.events.dto.UserDto;
import com.baribir.events.dto.UserPhotoDto;
import com.baribir.events.entity.User;
import com.baribir.events.entity.UserPhoto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public interface UserMapper extends IMapper<User, UserDto> {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDto(List<User> user);
    List<User> toEntity(List<UserDto> userDto);
}
