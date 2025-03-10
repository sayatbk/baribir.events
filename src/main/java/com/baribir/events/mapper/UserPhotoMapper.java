package com.baribir.events.mapper;

import com.baribir.events.dto.UserPhotoDto;
import com.baribir.events.entity.UserPhoto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface UserPhotoMapper extends IMapper<UserPhoto, UserPhotoDto> {
}
