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
import ru.ithub.aoas.payload.response.ProducerDto;
import ru.ithub.aoas.services.ProducerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/producers")
@RequiredArgsConstructor
public class ProducerController {

  @Autowired
  private final ProducerService producerService;

  @GetMapping
  public ResponseEntity<List<ProducerDto>> getAll() {
    return new ResponseEntity<>(producerService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{/id}")
  public ResponseEntity<ProducerDto> getProducer(@PathVariable Long id) {
    return new ResponseEntity<>(producerService.getProducer(id), HttpStatus.OK);
  }

  @PostMapping
  public ProducerDto create(@RequestBody ProducerDto dto) {
    return producerService.createProducer(dto);
  }

  @PutMapping("/{id}")
  public ProducerDto update(@PathVariable Long id, @RequestBody ProducerDto dto) {
    return producerService.updateProducer(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return producerService.delete(id);
  }
}
