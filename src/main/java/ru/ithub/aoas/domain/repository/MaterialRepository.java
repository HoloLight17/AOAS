package ru.ithub.aoas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.aoas.domain.entity.order.material.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
