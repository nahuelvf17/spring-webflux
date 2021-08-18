package com.novando.springboot.webflux;

import com.novando.springboot.webflux.models.product.dao.ProductoRepository;
import com.novando.springboot.webflux.models.product.documents.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class SpringbootWebfluxApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository repository;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	private static final Logger log = LoggerFactory.getLogger(SpringbootWebfluxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*


		mongoTemplate.dropCollection("productos").subscribe();
		Flux.just(new Producto("TV Panasonic LCD", 546.98),
				new Producto("Sony Camara HD", 133.65),
				new Producto("Memoria MICRO SD 512", 67.54),
				new Producto("Hp Notebook Intel", 4303.45),
				new Producto("Apple Ipod 3", 738.42),
				new Producto("Hp Notebook AMD", 5353.12),
				new Producto("Memoria MICRO SD 1G", 453.22),
				new Producto("Memoria MICRO SD 2G", 493.87),
				new Producto("BGH Notebook Intel I3", 1434.33)
				)
		.flatMap(producto -> {
			producto.setCreateAt(new Date());
			return repository.save(producto);
		})
		.subscribe(producto ->log.info("Insert: " + producto.getId() + " " + producto.getNombre()));
	*/
	}
}
