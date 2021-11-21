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
@RequestMapping(path="/carrito")
public class ElementoCarritoController {
	
	@Autowired
	private ElementoCarritoRepository carritoRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path="/add")
	public @ResponseBody String addProduct (@RequestParam int id
			, @RequestParam int num) {
		Optional<Product> p = productRepository.findById(id);
		if(p.isPresent()) {
			carritoRepository.save(new ElementoCarrito(p.get(), num, p.get().getPrecio()));
		}
		else return "That product does not exit";
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<ElementoCarrito> getAllProducts() {
		return carritoRepository.findAll();
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteProduct(@RequestParam int id) {		
		Optional<ElementoCarrito> ec = carritoRepository.findById(id);
		if(ec.isPresent()) {
			carritoRepository.deleteById(id);
		}
		else return "That ID does not exit";
		return "Deleted";
	}
}
