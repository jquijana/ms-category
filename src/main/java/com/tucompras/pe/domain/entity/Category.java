package com.tucompras.pe.domain.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "category")
public class Category {

  @DocumentId
  private String id;

  private String name;
  private String description;
  private String image;
  private Boolean isActive;
  private Integer order;
  private List<Item> items;
}
