package com.novando.springboot.webflux.controllers;

import com.novando.springboot.webflux.models.product.dao.ProductoRepository;
import com.novando.springboot.webflux.models.product.documents.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Locale;

@Controller
public class ProductController {
    @Autowired
    private ProductoRepository repository;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping({"/listar", "/"})
    private String listarDataDriver(Model model){
        Flux<Producto> productos = repository.findAll().map(producto->{
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        });

        productos.subscribe(prod-> log.info(prod.getNombre()));

        model.addAttribute("productos", productos);
        model.addAttribute("titulo", "Lista de productos");
        return "listar";
    }

    @GetMapping("listar-datadriver")
    private String listar(Model model){
        Flux<Producto> productos = repository.findAll().map(producto->{
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        }).delayElements(Duration.ofSeconds(1));

        productos.subscribe(prod-> log.info(prod.getNombre()));

        model.addAttribute("productos", new ReactiveDataDriverContextVariable(productos, 1));
        model.addAttribute("titulo", "Lista de productos");
        return "listar";
    }

    @GetMapping("listar-full")
    private String listarFull(Model model){
        Flux<Producto> productos = repository.findAll().map(producto->{
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        }).repeat(5000);

        productos.subscribe(prod-> log.info(prod.getNombre()));

        model.addAttribute("productos", productos);
        model.addAttribute("titulo", "Lista de productos");
        return "listar";
    }
}
