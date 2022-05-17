package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.OrderDto;
import ru.ithub.aoas.payload.response.OrderTypeDto;

public interface OrderTypeService {

  List<OrderTypeDto> getAll();

  OrderTypeDto getOrderType(Long id);

  OrderTypeDto createOrderType(OrderTypeDto dto);

  OrderTypeDto updateOrderType(Long id, OrderTypeDto dto);

  ResponseEntity<Object> delete(Long id);
}
