package com.novando.springboot.webflux.controllers;

import com.novando.springboot.webflux.models.product.dao.ProductoRepository;
import com.novando.springboot.webflux.models.product.documents.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductRestController {
    @Autowired
    private ProductoRepository repository;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping()
    public Flux<Producto> index() {
        Flux<Producto> productos = repository.findAll().map(producto->{
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        }).doOnNext(prod->log.info(prod.getNombre()));

        return productos;
    }

    @GetMapping("/{id}")
    public Mono<Producto> show(@PathVariable String id){
        Mono<Producto> producto = repository.findById(id);
        return producto;
    }
}
