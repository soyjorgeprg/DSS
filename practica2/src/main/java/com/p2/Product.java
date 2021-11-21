package com.p2;

import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	private String nombre;
	private String marca;
	private String descripcion;
	private double precio;
	
	//private ElementoCarrito ec;

	public Product(String nombre, String marca, String descripcion, double precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Product(String nombre, double precio) {
		this(nombre, "", "", precio);
	}
	
	public Product() {}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Product [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
}
