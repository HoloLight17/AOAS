package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.ClientDto;

public interface ClientService {

  List<ClientDto> getAll();

  ClientDto getClient(Long id);

  ClientDto registerClient(ClientDto dto);

  ClientDto updateClient(Long id, ClientDto dto);

  ResponseEntity<Object> delete(Long id);
}
