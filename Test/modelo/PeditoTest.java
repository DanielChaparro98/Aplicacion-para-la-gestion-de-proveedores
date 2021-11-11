package modelo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	
	
}
