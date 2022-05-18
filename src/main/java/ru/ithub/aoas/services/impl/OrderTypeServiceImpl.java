package ru.ithub.aoas.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.order.OrderType;
import ru.ithub.aoas.domain.repository.OrderTypeRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.OrderTypeDto;
import ru.ithub.aoas.services.OrderTypeService;

@Service
@RequiredArgsConstructor
class OrderTypeServiceImpl implements OrderTypeService {

  private final OrderTypeRepository orderTypeRepository;

  @Override
  public List<OrderTypeDto> getAll() {
    return orderTypeRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public OrderTypeDto getOrderType(Long id) {
    return convert(
        orderTypeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(OrderType.class, id))
    );
  }

  private OrderTypeDto convert(OrderType entity) {
    return new OrderTypeDto(
        entity.getId(),
        entity.getName()
    );
  }

  @Override
  public OrderTypeDto createOrderType(OrderTypeDto dto) {
    OrderType orderType = new OrderType();
    updateOrderType(orderType, dto);
    return convert(orderTypeRepository.save(orderType));
  }

  @Override
  public OrderTypeDto updateOrderType(Long id, OrderTypeDto dto) {
    OrderType orderType = orderTypeRepository.findById(id).orElseThrow(() -> new NotFoundException(OrderType.class, id));
    updateOrderType(orderType, dto);

    return convert(orderTypeRepository.save(orderType));
  }

  @Override
  public ResponseEntity<Object> delete(Long id) {
    orderTypeRepository.delete(orderTypeRepository.getById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void updateOrderType(OrderType order, OrderTypeDto dto) {
    if (dto.getName() != null) {
      order.setName(dto.getName());
    }
  }
}
