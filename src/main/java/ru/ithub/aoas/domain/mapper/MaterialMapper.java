package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.order.material.Material;
import ru.ithub.aoas.payload.response.MaterialDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaterialMapper {
    MaterialDto toDto(Material entity);
    List<MaterialDto> toDto(List<Material> entities);
}
