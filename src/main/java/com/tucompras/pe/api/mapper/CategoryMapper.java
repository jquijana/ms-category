package com.tucompras.pe.api.mapper;

import com.tucompras.pe.api.dto.CategoryDTO;
import com.tucompras.pe.api.dto.ItemDTO;
import com.tucompras.pe.domain.entity.Category;
import com.tucompras.pe.domain.entity.Item;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

  public Category toCategory(CategoryDTO categoryDTO) {
    return Category.builder()
        .id(categoryDTO.getId() == null ? UUID.randomUUID().toString() : categoryDTO.getId())
        .name(categoryDTO.getName())
        .description(categoryDTO.getDescription())
        .image(categoryDTO.getImage())
        .order(categoryDTO.getOrder())
        .isActive(categoryDTO.getIsActive())
        .items(
            categoryDTO.getItems() != null
                ? categoryDTO.getItems().stream().map(x -> toItem(x)).collect(Collectors.toList())
                : null)
        .build();
  }

  public CategoryDTO toCategoryDTO(Category category) {
    return CategoryDTO.builder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .image(category.getImage())
        .order(category.getOrder())
        .isActive(category.getIsActive())
        .items(
            category.getItems() != null
                ? category.getItems().stream().map(x -> toItemDTO(x)).collect(Collectors.toList())
                : null)
        .build();
  }

  private ItemDTO toItemDTO(Item item) {
    return ItemDTO.builder()
        .id(item.getId())
        .name(item.getName())
        .description(item.getDescription())
        .image(item.getImage())
        .build();
  }

  private Item toItem(ItemDTO itemDTO) {
    return Item.builder()
        .id(itemDTO.getId())
        .name(itemDTO.getName())
        .description(itemDTO.getDescription())
        .image(itemDTO.getImage())
        .build();
  }
}
