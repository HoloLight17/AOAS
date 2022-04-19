package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.order.OrderType;
import ru.ithub.aoas.payload.response.OrderTypeDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTypeMapper {
    OrderTypeDto toDto(OrderType entity);
    List<OrderTypeDto> toDto(List<OrderType> entities);
}
