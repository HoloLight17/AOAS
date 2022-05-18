package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.ProducerDto;

public interface ProducerService {

  List<ProducerDto> getAll();

  ProducerDto getProducer(Long id);

  ProducerDto createProducer(ProducerDto dto);

  ProducerDto updateProducer(Long id, ProducerDto dto);

  ResponseEntity<Object> delete(Long id);
}
