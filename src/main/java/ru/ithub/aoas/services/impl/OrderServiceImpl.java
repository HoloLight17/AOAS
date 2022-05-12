package ru.ithub.aoas.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.Client;
import ru.ithub.aoas.domain.entity.User;
import ru.ithub.aoas.domain.entity.order.Order;
import ru.ithub.aoas.domain.entity.order.OrderStatus;
import ru.ithub.aoas.domain.repository.ClientRepository;
import ru.ithub.aoas.domain.repository.MaterialRepository;
import ru.ithub.aoas.domain.repository.OrderRepository;
import ru.ithub.aoas.domain.repository.OrderTypeRepository;
import ru.ithub.aoas.domain.repository.UserRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.OrderDto;
import ru.ithub.aoas.services.OrderService;

@Service
@RequiredArgsConstructor
class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ClientRepository clientRepository;
  private final UserRepository userRepository;
  private final OrderTypeRepository orderTypeRepository;
  private final MaterialRepository materialRepository;

  @Override
  public OrderDto createOrder(OrderDto dto) {
    Order order = new Order();
    updateOrder(order, dto);
    return convert(orderRepository.save(order));
  }

  @Override
  public OrderDto updateOrder(Long id, OrderDto dto) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(Order.class, id));
    updateOrder(order, dto);

    return convert(orderRepository.save(order));
  }

  private OrderDto convert(Order entity) {
    return new OrderDto(
        entity.getId(),
        entity.getInformation(),
        entity.getCreatedAt(),
        entity.getDoneAt(),
        entity.getStatus().name(),
        entity.getClient().getId(),
        entity.getPerformer().getId(),
        entity.getOrderType().getId(),
        entity.getRequiredMaterials()
    );
  }

  private void updateOrder(Order order, OrderDto dto) {
    if (dto.getInformation() != null) {
      order.setInformation(dto.getInformation());
    }

    if (dto.getDoneAt() != null) {
      order.setDoneAt(dto.getDoneAt());
    }

    if (dto.getOrderStatus() != null) {
      order.setStatus(OrderStatus.getByName(dto.getOrderStatus()));
    }

    if (dto.getClientId() != null) {
      order.setClient(
          clientRepository.findById(
                  dto.getClientId())
              .orElseThrow(() -> new NotFoundException(Client.class, dto.getClientId()))
      );
    }

    if (dto.getPerformerId() != null) {
      order.setPerformer(
          userRepository.findById(dto.getPerformerId())
              .orElseThrow(() -> new NotFoundException(User.class, dto.getClientId()))
      );
    }

    if (dto.getOrderTypeId() != null) {
      order.setOrderType(
          orderTypeRepository.findById(dto.getOrderTypeId())
              .orElseThrow(() -> new NotFoundException(Client.class, dto.getClientId()))
      );
    }

    if (dto.getRequiredMaterials() != null && !dto.getRequiredMaterials().isEmpty()) {
      Map<Long, Integer> materials = new HashMap<>();
      for (Entry<Long, Integer> entry : dto.getRequiredMaterials().entrySet()) {
        if (materialRepository.existsById(entry.getKey())) {
          materials.put(entry.getKey(), entry.getValue());
        }
      }

      order.setRequiredMaterials(materials);
    }

  }
}
