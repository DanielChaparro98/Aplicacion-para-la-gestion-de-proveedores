package modelo;

import java.io.Serializable;
import java.sql.Date;


public class Pedido implements Serializable {

	
	private Long id;
	private Long cantidadProductos;
	private String estado;
	private Date fechaEntrega;
	private String motivo;
	private Proveedor idProveedor;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, Long cantidadProductos, String estado, Date fechaEntrega,Proveedor idProveedor) {
		super();
		this.id = id;
		this.cantidadProductos = cantidadProductos;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.idProveedor=idProveedor;
	}
	
	public Pedido( Long cantidadProductos, String estado, Date fechaEntrega,String motivo,Proveedor idProveedor) {
		
		this.cantidadProductos = cantidadProductos;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.motivo=motivo;
		this.idProveedor=idProveedor;
	}
        
        public Pedido(Long id, String estado, Date fechaEntrega,String motivo) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.motivo=motivo;
		
        }
        
        public Pedido(Long id, String estado,String motivo) {
    		super();
    		this.id = id;
    		this.estado = estado;
    		this.motivo=motivo;
    		
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

	
	
	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cantidadProductos=" + cantidadProductos + ", estado=" + estado
				+ ", fechaEntrega=" + fechaEntrega + ", motivo=" + motivo + ", idProveedor=" + idProveedor + "]";
	}


}
