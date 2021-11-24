package modelo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.PedidoDTO;

public class PeditoTest {
	
	@DisplayName("Insercion Pedido Null")
	@Test
	public void testInsercionPedidoNull() {
		PedidoDTO pdto=PedidoDTO.instance();
		String rta=pdto.insert(null);
		assertNotNull(rta);
	}
	
	@DisplayName("Insercion Pedido sin datos")
	@Test
	public void testInsercionPedidoSinDatos() {
		PedidoDTO pdto= PedidoDTO.instance();
		Pedido pedido= new Pedido();
		String rta=pdto.insert(pedido);
		assertNotNull(rta);
	}
	
	@DisplayName("Insercion Pedido ok")
	@Test
	public void testInsercionPedidoOk() {
		PedidoDTO pdto=PedidoDTO.instance();
		Proveedor proveedor=new Proveedor();
		proveedor.setId(1l);
		Pedido pedido= new Pedido();
		Date fecha= new Date(116,5,3);
		pedido.setEstado("Estado");
		pedido.setFechaEntrega(fecha);
		pedido.setCantidadProductos(2323L);
		pedido.setMotivo("Motivo");
		pedido.setIdProveedor(proveedor);
		String rta= pdto.insert(pedido);
		assertNotNull(rta);
	}
	
	@DisplayName("Actualizacion Pedido sin datos")
	@Test
	public void testActualizacionPedido() {
		PedidoDTO pdto= PedidoDTO.instance();
		Pedido pedido = new Pedido();
	    String rta=pdto.update(pedido);
	    assertNotNull(rta);
	}
	
	@DisplayName("Actualizacion Pedido ok")
	@Test
	public void testActualizacionPedidoOk() {
		PedidoDTO pdto= PedidoDTO.instance();
		Pedido pedido= new Pedido();
		Date fecha= new Date(116,5,3);
		pedido.setId(1L);
		pedido.setEstado("Estado");
		pedido.setCantidadProductos(123L);
		pedido.setFechaEntrega(fecha);
		String rta= pdto.update(pedido);
		assertNotNull(rta);
		
	}
	
	@DisplayName("Eliminacion Pedido sin datos")
	@Test
	public void testEliminacionPedidoSinDatos() {
		PedidoDTO pdto= PedidoDTO.instance();
		Pedido pedido= new Pedido();
		String rta=pdto.deleted(pedido.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Eliminacion Pedido Ok")
	@Test
	public void testEliminacionOk() {
		PedidoDTO pdto= PedidoDTO.instance();
		Pedido pedido= new Pedido();
		pedido.setId(1L);
		String rta=pdto.deleted(pedido.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Seleccionar Pedidos")
	@Test
	public void testSeleccionarOk() {
		PedidoDTO pdto= PedidoDTO.instance();
		List<Pedido> pedidos=pdto.select();
		assertNotNull(pedidos);
	}
}
