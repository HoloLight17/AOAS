package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.OrderDto;

public interface OrderService {

  List<OrderDto> getAll();

  OrderDto getOrder(Long id);

  OrderDto createOrder(OrderDto dto);

  OrderDto updateOrder(Long id, OrderDto dto);

  ResponseEntity<Object> delete(Long id);
}
