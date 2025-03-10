package com.baribir.events.mapper;

import java.util.List;

public interface IMapper<E, DTO> {
    DTO toDto(E entity);
    E toEntity(DTO dto);
    List<E> toEntity(List<DTO> dtoList);
    List<DTO> toDto(List<E> entityList);
}
