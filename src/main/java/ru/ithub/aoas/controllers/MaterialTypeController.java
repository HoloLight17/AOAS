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
import ru.ithub.aoas.payload.response.MaterialTypeDto;
import ru.ithub.aoas.services.MaterialTypeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/material_types")
@RequiredArgsConstructor
public class MaterialTypeController {

  @Autowired
  private final MaterialTypeService materialTypeService;

  @GetMapping
  public ResponseEntity<List<MaterialTypeDto>> getAll() {
    return new ResponseEntity<>(materialTypeService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{/id}")
  public ResponseEntity<MaterialTypeDto> getProducer(@PathVariable Long id) {
    return new ResponseEntity<>(materialTypeService.getMaterialType(id), HttpStatus.OK);
  }

  @PostMapping
  public MaterialTypeDto create(@RequestBody MaterialTypeDto dto) {
    return materialTypeService.createMaterialType(dto);
  }

  @PutMapping("/{id}")
  public MaterialTypeDto update(@PathVariable Long id, @RequestBody MaterialTypeDto dto) {
    return materialTypeService.updateMaterialType(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    return materialTypeService.delete(id);
  }
}
