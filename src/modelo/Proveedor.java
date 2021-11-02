package modelo;

import java.io.Serializable;

public class Proveedor implements Serializable {
	
	private Long id;
	private String nit;
	private String nombre;
	private String telefono;
	
	
	
	public Proveedor() {
		super();
	}

	public Proveedor(Long id, String nit, String nombre, String telefono) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
