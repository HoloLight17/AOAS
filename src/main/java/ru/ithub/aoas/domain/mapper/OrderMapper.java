package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.order.Order;
import ru.ithub.aoas.payload.response.OrderDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderDto toDto(Order entity);
    List<Order> toDto(List<Order> entities);
}
