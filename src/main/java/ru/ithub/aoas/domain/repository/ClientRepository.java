package ru.ithub.aoas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.aoas.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
