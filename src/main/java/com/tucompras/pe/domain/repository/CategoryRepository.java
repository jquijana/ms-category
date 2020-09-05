package com.tucompras.pe.domain.repository;

import com.tucompras.pe.domain.entity.Category;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface CategoryRepository extends FirestoreReactiveRepository<Category> {

  Flux<Category> findAllByIsActive(Boolean isActive);
}
