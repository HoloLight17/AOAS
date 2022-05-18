package ru.ithub.aoas.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.order.material.Producer;
import ru.ithub.aoas.domain.repository.ProducerRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.ProducerDto;
import ru.ithub.aoas.services.ProducerService;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

  private final ProducerRepository producerRepository;

  @Override
  public List<ProducerDto> getAll() {
    return producerRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public ProducerDto getProducer(Long id) {
    return convert(producerRepository.findById(id).orElseThrow(() -> new NotFoundException(Producer.class, id)));
  }

  private ProducerDto convert(Producer entity) {
    return new ProducerDto(entity.getId(), entity.getName(), entity.getLink());
  }

  @Override
  public ProducerDto createProducer(ProducerDto dto) {
    Producer producer = new Producer();
    updateProducer(producer, dto);
    return convert(producerRepository.save(producer));
  }

  @Override
  public ProducerDto updateProducer(Long id, ProducerDto dto) {
    Producer producer = producerRepository.findById(id).orElseThrow(() -> new NotFoundException(Producer.class, id));
    updateProducer(producer, dto);

    return convert(producerRepository.save(producer));
  }

  @Override
  public ResponseEntity<Object> delete(Long id) {
    producerRepository.delete(producerRepository.getById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void updateProducer(Producer producer, ProducerDto dto) {
    if (dto.getName() != null) {
      producer.setName(dto.getName());
    }

    if (dto.getLink() != null) {
      producer.setLink(dto.getLink());
    }

  }
}
