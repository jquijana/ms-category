package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.CategoryDTO;
import com.tucompras.pe.api.mapper.CategoryMapper;
import com.tucompras.pe.domain.entity.Category;
import com.tucompras.pe.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository userRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Flux<CategoryDTO> findAll() {
        return userRepository.findAllByIsActive(true).sort(Comparator.comparing(Category::getOrder)).map(x -> categoryMapper.toCategoryDTO(x));
    }

    @Override
    public Mono<CategoryDTO> save(CategoryDTO categoryDTO) {
        Mono<Category> categoryMono = userRepository.save(categoryMapper.toCategory(categoryDTO));
        return categoryMono.map(x -> categoryMapper.toCategoryDTO(x));
    }

    @Override
    public Flux<CategoryDTO> saveAll(List<CategoryDTO> categories) {
        Flux<Category> categoryFlux = userRepository.saveAll(categories.stream().map(x -> categoryMapper.toCategory(x)).collect(Collectors.toList()));
        return categoryFlux.map(x -> categoryMapper.toCategoryDTO(x));
    }

    @Override
    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
}
