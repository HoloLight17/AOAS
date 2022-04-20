package ru.ithub.aoas.services;

import ru.ithub.aoas.payload.response.OrderDto;

public interface OrderService {
  OrderDto createOrder(OrderDto dto);
  OrderDto updateOrder(Long id, OrderDto dto);
}
