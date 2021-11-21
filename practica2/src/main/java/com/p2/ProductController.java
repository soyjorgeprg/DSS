package com.p2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/catalogue")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path="/add")
	public @ResponseBody String addProduct (@RequestParam String name
			, @RequestParam String marca
			, @RequestParam String descripcion
			, @RequestParam double precio) {

		productRepository.save(new Product(name, marca, descripcion, precio));
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteProduct(@RequestParam int num) {		
		Optional<Product> p = productRepository.findById(num);
		if(p.isPresent()) productRepository.deleteById(num);
		else return "That ID does not exit";
		return "Deleted";
	}
}
