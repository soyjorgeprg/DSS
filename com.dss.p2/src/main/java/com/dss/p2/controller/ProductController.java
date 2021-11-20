package com.dss.p2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dss.p2.model.Product;

@RestController
public class ProductController {
	
	private List<Product> catalogo = new ArrayList<Product>();
	
	@PostConstruct
	public void init() {
		catalogo.add(new Product("Galletas", "Principe", "Galletas rellenas de chocolate", 1.49));
		catalogo.add(new Product("Macarrones", "Hacendado", "Macarrones de trigo", 2.8));
		catalogo.add(new Product("Guacamole", "Hacendado", "Guacamole", 1.59));
	}

	@GetMapping("/product")
	public Product product(@RequestParam(value = "num", defaultValue = "0") int num) {
		num = num % catalogo.size();
		return catalogo.get(num);
	}
	
	@GetMapping("/completeCatalogue")
	public Object[] catalogoCompleto() {
		return catalogo.toArray();
	}
	
	@PostMapping("/addBasicProduct")
	public void addBasicProduct(@RequestParam(value = "name", defaultValue = "---") String name, 
			@RequestParam(value = "value", defaultValue = "0") double precio) {
		catalogo.add(new Product(name, precio));
	}
	
	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@RequestParam(value = "num") String num) {
		catalogo.removeIf(Product.containsNombre(num));
	}

}
