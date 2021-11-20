package com.dss.p2.modelos;

public class Product {
	
	private final long id;
	private final String content;

	public Product(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
