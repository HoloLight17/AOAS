package ru.ithub.aoas.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.order.Order;
import ru.ithub.aoas.domain.entity.order.OrderType;
import ru.ithub.aoas.domain.entity.order.material.MaterialType;
import ru.ithub.aoas.domain.repository.MaterialTypeRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.MaterialTypeDto;
import ru.ithub.aoas.services.MaterialTypeService;

@Service
@RequiredArgsConstructor
class MaterialTypeServiceImpl implements MaterialTypeService {

  private final MaterialTypeRepository materialTypeRepository;

  @Override
  public List<MaterialTypeDto> getAll() {
    return materialTypeRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
  }

  @Override
  public MaterialTypeDto getMaterialType(Long id) {
    return convert(
        materialTypeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(MaterialType.class, id))
    );
  }

  private MaterialTypeDto convert(MaterialType entity) {
    return new MaterialTypeDto(
        entity.getId(),
        entity.getName()
    );
  }

  @Override
  public MaterialTypeDto createMaterialType(MaterialTypeDto dto) {
    MaterialType orderType = new MaterialType();
    updateOrderType(orderType, dto);
    return convert(materialTypeRepository.save(orderType));
  }

  @Override
  public MaterialTypeDto updateMaterialType(Long id, MaterialTypeDto dto) {
    MaterialType orderType = materialTypeRepository.findById(id).orElseThrow(() -> new NotFoundException(Order.class, id));
    updateOrderType(orderType, dto);

    return convert(materialTypeRepository.save(orderType));
  }

  @Override
  public ResponseEntity<Object> delete(Long id) {
    materialTypeRepository.delete(materialTypeRepository.getById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void updateOrderType(MaterialType order, MaterialTypeDto dto) {
    if (dto.getName() != null) {
      order.setName(dto.getName());
    }
  }
}
