package ru.ithub.aoas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import ru.ithub.aoas.payload.response.MaterialDto;

public interface MaterialService {

  List<MaterialDto> getAll();

  MaterialDto getMaterial(Long id);

  MaterialDto createMaterial(MaterialDto dto);

  MaterialDto updateMaterial(Long id, MaterialDto dto);

  ResponseEntity<Object> delete(Long id);
}
