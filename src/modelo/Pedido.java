package modelo;

import java.io.Serializable;
import java.sql.Date;


public class Pedido implements Serializable {

	
	private Long id;
	private Long cantidadProductos;
	private String estado;
	private Date fechaEntrega;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, Long cantidadProductos, String estado, Date fechaEntrega) {
		super();
		this.id = id;
		this.cantidadProductos = cantidadProductos;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(Long cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cantidadProductos=" + cantidadProductos + ", estado=" + estado
				+ ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	

}
