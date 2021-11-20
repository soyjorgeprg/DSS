package com.dss.p2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dss.p2.model.Product;

@RestController
public class ProductController {
	
	/*@Autowired
	private List<Product> catalogo;
	
	@PostConstruct
	public void init() {
		
		catalogo.add(new Product("Galletas", "Principe", "Galletas rellenas de chocolate", 1.49));
		catalogo.add(new Product("Lasaña", "Hacendado", "Lasaña de verduras", 2.8));
		catalogo.add(new Product("Guacamole", "Hacendado", "Guacamole", 1.59));

	}*/
	public List<Product> catalogo = new ArrayList<Product>();

	@GetMapping("/catalogo")
	public Product catalogo(@RequestParam(value = "num", defaultValue = "0") int num) {
		catalogo.add(new Product("Galletas", "Principe", "Galletas rellenas de chocolate", 1.49));
		catalogo.add(new Product("Lasaña", "Hacendado", "Lasaña de verduras", 2.8));
		catalogo.add(new Product("Guacamole", "Hacendado", "Guacamole", 1.59));
		num = num % catalogo.size();
		return catalogo.get(num);
	}
	
	@GetMapping("/catalogoCompleto")
	public Object[] catalogoCompleto() {
		return catalogo.toArray();
	}
	
	@PostMapping("/addBasicProduct")
	public Product addBasicProduct(@RequestParam(value = "name", defaultValue = "---") String name, 
			@RequestParam(value = "precio", defaultValue = "0") double precio) {
		catalogo.add(new Product(name, precio));
		
		return catalogo.get(0);
	}

}
