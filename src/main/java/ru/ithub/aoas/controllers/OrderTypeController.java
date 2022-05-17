package ru.ithub.aoas.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ithub.aoas.payload.response.OrderTypeDto;
import ru.ithub.aoas.services.OrderTypeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order_types")
@RequiredArgsConstructor
public class OrderTypeController {

  @Autowired
  private final OrderTypeService orderServiceType;

  @GetMapping
  public List<OrderTypeDto> getAll() {
    return orderServiceType.getAll();
  }

  @GetMapping("{/id}")
  public OrderTypeDto getOrder(@PathVariable Long id) {
    return orderServiceType.getOrderType(id);
  }

  @PostMapping
  public OrderTypeDto create(@RequestBody OrderTypeDto dto) {
    return orderServiceType.createOrderType(dto);
  }

  @PutMapping("/{id}")
  public OrderTypeDto update(@PathVariable Long id, @RequestBody OrderTypeDto dto) {
    return orderServiceType.updateOrderType(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return orderServiceType.delete(id);
  }
}
