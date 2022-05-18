package ru.ithub.aoas.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.Client;
import ru.ithub.aoas.domain.entity.order.material.Producer;
import ru.ithub.aoas.domain.repository.ClientRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.ClientDto;
import ru.ithub.aoas.services.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Override
  public List<ClientDto> getAll() {
    return clientRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public ClientDto getClient(Long id) {
    return convert(clientRepository.findById(id).orElseThrow(() -> new NotFoundException(Producer.class, id)));
  }

  private ClientDto convert(Client entity) {
    return new ClientDto(entity.getId(), entity.getFullName(), entity.getPhoneNumber(), entity.getEmail());
  }

  @Override
  public ClientDto registerClient(ClientDto dto) {
    Client client = new Client();
    updateClient(client, dto);
    return convert(clientRepository.save(client));
  }

  public ClientDto updateClient(Long id, ClientDto dto) {
    Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException(Client.class, id));
    updateClient(client, dto);

    return convert(clientRepository.save(client));
  }

  @Override
  public ResponseEntity<Object> delete(Long id) {
    clientRepository.delete(clientRepository.getById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void updateClient(Client client, ClientDto dto) {
    if (dto.getFullName() != null) {
      client.setFullName(dto.getFullName());
    }
    if (dto.getPhoneNumber() != null) {
      client.setPhoneNumber(dto.getPhoneNumber());
    }
    if (dto.getEmail() != null) {
      client.setEmail(dto.getEmail());
    }
  }
}
