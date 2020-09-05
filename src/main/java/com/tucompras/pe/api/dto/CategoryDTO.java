package com.tucompras.pe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

  private String id;
  private String name;
  private String description;
  private String image;
  private Boolean isActive;
  private Integer order;
  private List<ItemDTO> items;
}
