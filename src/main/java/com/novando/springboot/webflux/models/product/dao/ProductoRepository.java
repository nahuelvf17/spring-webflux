package com.novando.springboot.webflux.models.product.dao;

import com.novando.springboot.webflux.models.product.documents.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
