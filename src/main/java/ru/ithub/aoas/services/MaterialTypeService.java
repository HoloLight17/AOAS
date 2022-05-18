package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.MaterialTypeDto;

public interface MaterialTypeService {

  List<MaterialTypeDto> getAll();

  MaterialTypeDto getMaterialType(Long id);

  MaterialTypeDto createMaterialType(MaterialTypeDto dto);

  MaterialTypeDto updateMaterialType(Long id, MaterialTypeDto dto);

  ResponseEntity<Object> delete(Long id);
}
