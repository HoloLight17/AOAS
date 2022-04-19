package ru.ithub.aoas.services;

import org.springframework.data.domain.Page;
import ru.ithub.aoas.payload.response.ClientDto;

import java.util.Collection;

public interface ClientService {
    ClientDto getById(Long id);
    Page<ClientDto> getAll(int page, int size);
    ClientDto create(ClientDto dto);
    ClientDto update(Long id, ClientDto dto);
    void delete(Collection<Long> ids);
}
