package ru.ithub.aoas.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ithub.aoas.payload.response.OrderDto;
import ru.ithub.aoas.services.OrderService;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @PostMapping
  public OrderDto create(@RequestBody OrderDto dto) {
    return orderService.createOrder(dto);
  }

  @PutMapping("/{id}")
  public OrderDto update(@PathVariable Long id, @RequestBody OrderDto dto) {
    return orderService.updateOrder(id, dto);
  }
}
