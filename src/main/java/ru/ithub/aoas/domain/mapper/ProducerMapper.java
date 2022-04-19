package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.order.material.Producer;
import ru.ithub.aoas.payload.response.ProducerDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProducerMapper {
    ProducerDto toDto(Producer entity);
    List<ProducerDto> toDto(List<Producer> entities);
}
