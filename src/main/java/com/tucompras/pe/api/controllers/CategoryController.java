package com.tucompras.pe.api.controllers;

import com.tucompras.pe.api.dto.CategoryDTO;
import com.tucompras.pe.api.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

  private final ICategoryService categoryService;

  @GetMapping
  private Flux<CategoryDTO> getAll() {
    return categoryService.findAll();
  }

  @PostMapping
  private Mono<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
    return categoryService.save(categoryDTO);
  }

  @DeleteMapping("/{id}")
  private Mono<Void> delete(@PathVariable("id") String id) {
    return categoryService.delete(id);
  }
}
