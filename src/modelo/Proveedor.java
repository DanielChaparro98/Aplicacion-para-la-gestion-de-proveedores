package modelo;

import java.io.Serializable;

public class Proveedor implements Serializable {
	
	private Long id;
	private String nit;
	private String nombre;
	private String telefono;
	private Producto idProducto;
	
	
	public Proveedor() {
		super();
	}

	public Proveedor(Long id, String nit, String nombre, String telefono,Producto idProducto) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idProducto=idProducto;
	}
	
	public Proveedor( String nit, String nombre, String telefono,Producto idProducto) {
		
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idProducto=idProducto;
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

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nit=" + nit + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", idProducto=" + idProducto + "]";
	}
	
	

}
