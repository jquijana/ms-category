package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.CategoryDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICategoryService {

  Flux<CategoryDTO> findAll();

  Mono<CategoryDTO> save(CategoryDTO categoryDTO);

  Mono<Void> delete(String id);
}
