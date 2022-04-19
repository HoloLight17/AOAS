package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.order.material.MaterialType;
import ru.ithub.aoas.payload.response.MaterialTypeDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaterialTypeMapper {
    MaterialTypeDto toDto(MaterialType entity);
    List<MaterialTypeDto> toDto(List<MaterialType> entities);
}
