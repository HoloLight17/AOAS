package ru.ithub.aoas.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.order.material.Material;
import ru.ithub.aoas.domain.entity.order.material.MaterialType;
import ru.ithub.aoas.domain.entity.order.material.Producer;
import ru.ithub.aoas.domain.repository.MaterialRepository;
import ru.ithub.aoas.domain.repository.MaterialTypeRepository;
import ru.ithub.aoas.domain.repository.ProducerRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.MaterialDto;
import ru.ithub.aoas.services.MaterialService;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

  private final MaterialRepository materialRepository;
  private final MaterialTypeRepository materialTypeRepository;
  private final ProducerRepository producerRepository;

  @Override
  public List<MaterialDto> getAll() {
    return materialRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public MaterialDto getMaterial(Long id) {
    return convert(materialRepository.findById(id).orElseThrow(
        () -> new NotFoundException(Material.class, id)
    ));
  }

  @Override
  public MaterialDto createMaterial(MaterialDto dto) {
    Material material = new Material();
    updateMaterial(material, dto);
    return convert(materialRepository.save(material));
  }

  @Override
  public MaterialDto updateMaterial(Long id, MaterialDto dto) {
    Material material = materialRepository.findById(id).orElseThrow(
        () -> new NotFoundException(Material.class, id)
    );
    updateMaterial(material, dto);
    return convert(materialRepository.save(material));
  }

  private void updateMaterial(Material material, MaterialDto dto) {
    if (dto.getName() != null) {
      material.setName(dto.getName());
    }

    if (dto.getMaterialTypeId() != null) {
      material.setMaterialType(materialTypeRepository
          .findById(dto.getMaterialTypeId())
          .orElseThrow(
              () -> new NotFoundException(
                  MaterialType.class, dto.getMaterialTypeId()))
      );
    }

    if (dto.getProducerId() != null) {
      material.setProducer(producerRepository
          .findById(dto.getProducerId())
          .orElseThrow(
              () -> new NotFoundException(
                  Producer.class, dto.getProducerId()))
      );
    }
  }

  @Override
  public ResponseEntity<Object> delete(Long id) {
    materialRepository.delete(materialRepository.getById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private MaterialDto convert(Material entity) {
    return new MaterialDto(
        entity.getId(),
        entity.getName(),
        entity.getMaterialType().getId(),
        entity.getProducer().getId()
    );
  }
}
