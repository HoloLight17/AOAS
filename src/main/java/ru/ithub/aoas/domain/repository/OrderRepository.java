package ru.ithub.aoas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.aoas.domain.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
