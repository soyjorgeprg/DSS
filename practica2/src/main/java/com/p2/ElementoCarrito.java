package com.p2;

import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
public class ElementoCarrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@MapsId
	@OneToOne()
	private Product producto;
	private double cantidad;
	private double precio;
	
	public ElementoCarrito() {}
	
	public ElementoCarrito(Product p, double precio) {
		this(p, 1, precio);
	}
	
	public ElementoCarrito(Product p, double cantidad, double precio) {
		this.producto = p;
		this.cantidad = cantidad;
		this.precio = precio*cantidad;
	}
	
	public int getId() {
		return id;
	}

	public Product getProducto() {
		return producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
