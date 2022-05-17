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
import ru.ithub.aoas.payload.response.MaterialDto;
import ru.ithub.aoas.services.MaterialService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class MaterialController {

  @Autowired
  private final MaterialService materialService;

  @GetMapping
  public ResponseEntity<List<MaterialDto>> getAll() {
    return new ResponseEntity<>(materialService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{/id}")
  public ResponseEntity<MaterialDto> getProducer(@PathVariable Long id) {
    return new ResponseEntity<>(materialService.getMaterial(id), HttpStatus.OK);
  }

  @PostMapping
  public MaterialDto create(@RequestBody MaterialDto dto) {
    return materialService.createMaterial(dto);
  }

  @PutMapping("/{id}")
  public MaterialDto update(@PathVariable Long id, @RequestBody MaterialDto dto) {
    return materialService.updateMaterial(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return materialService.delete(id);
  }
}
