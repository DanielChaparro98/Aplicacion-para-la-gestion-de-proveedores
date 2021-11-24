package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private Long id;
	private String nombre;
	private String tipo;
	
	
	public Producto(Long id, String nombre, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	
	public Producto( String nombre, String tipo) {

		this.nombre = nombre;
		this.tipo = tipo;
	}
	public Producto() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
	
}
