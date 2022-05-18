package ru.ithub.aoas.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import ru.ithub.aoas.payload.response.ClientDto;
import ru.ithub.aoas.services.ClientService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

  @Autowired
  private final ClientService clientService;

  @GetMapping
  public ResponseEntity<List<ClientDto>> getAll() {
    return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{/id}")
  public ResponseEntity<ClientDto> getProducer(@PathVariable Long id) {
    return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
  }

  @PostMapping
  public ClientDto create(@RequestBody ClientDto dto) {
    return clientService.registerClient(dto);
  }

  @PutMapping("/{id}")
  public ClientDto update(@PathVariable Long id, @RequestBody ClientDto dto) {
    return clientService.updateClient(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return clientService.delete(id);
  }
}
