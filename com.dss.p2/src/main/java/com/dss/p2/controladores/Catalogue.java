package com.dss.p2.controladores;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dss.p2.modelos.Product;

@RestController
public class Catalogue {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Product greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Product(counter.incrementAndGet(), String.format(template, name));
	}

}
