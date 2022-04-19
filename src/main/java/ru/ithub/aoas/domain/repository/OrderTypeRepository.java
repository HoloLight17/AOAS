package ru.ithub.aoas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.aoas.domain.entity.order.OrderType;

public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}
