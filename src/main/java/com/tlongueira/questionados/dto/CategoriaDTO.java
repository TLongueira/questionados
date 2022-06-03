package com.tlongueira.questionados.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {
	@NotBlank
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [nombre=" + nombre + "]";
	}

	public CategoriaDTO(@NotBlank String nombre) {
		super();
		this.nombre = nombre;
	}

	public CategoriaDTO() {
		super();
	}
	
}
