package modelo;

import org.junit.jupiter.api.Test;

import dto.PedidoDTO;
import dto.ProductoDTO;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;

public class ProductoTest {

	@DisplayName("Insercion Producto null")
	@Test
	public void testInsercionProductoNull() {
		ProductoDTO producto= ProductoDTO.instance();
		String rta=producto.insert(null);
		assertNotNull(rta);
	}
	
	@DisplayName("Insercion Pedido sin datos")
	@Test
	public void testInsercionProductoSinDatos() {
		ProductoDTO pdto= ProductoDTO.instance();
		Producto producto= new Producto();
		String rta= pdto.insert(producto);
		assertNotNull(rta);
	}
	
	@DisplayName("Insercion Producto ok")
	@Test
	public void testInsercionProductoOk() {
		ProductoDTO pdto=ProductoDTO.instance();
		Producto producto= new Producto();
		producto.setNombre("Nombre1");
		producto.setTipo("Tipo1");
		String rta=pdto.insert(producto);
		assertNotNull(rta);
	}
	
	@DisplayName("Actualizacion Producto sin datos")
	@Test
	public void testActualizacionProducto() {
		ProductoDTO pdto=ProductoDTO.instance();
		Producto producto= new Producto();
		String rta=pdto.update(producto);
		assertNotNull(rta);
	}
	
	@DisplayName("Actualizacion Producto ok")
	@Test
	public void testActualizacionProductoOk() {
		ProductoDTO pdto=ProductoDTO.instance();
		Producto producto=new Producto();
		producto.setId(1L);
		producto.setNombre("Nombre1");
		producto.setTipo("Tipo1");
		String rta=pdto.update(producto);
		assertNotNull(rta);
	}
	
	@DisplayName("Eliminacion Producto sin datos")
	@Test
	public void testEliminacionProductoSinDatos() {
		ProductoDTO pdto= ProductoDTO.instance();
		Producto producto=new Producto();
		String rta = pdto.deleted(producto.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Eliminacion Producto ok")
	@Test
	public void testEliminacionOk() {
		ProductoDTO pdto=ProductoDTO.instance();
		Producto producto= new Producto();
		producto.setId(1L);
		String rta=pdto.deleted(producto.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Seleccionar Productos")
	@Test
	public void testSeleccionarOk() {
		ProductoDTO pdto=ProductoDTO.instance();
		List<Producto> productos=pdto.select();
		assertNotNull(productos);
	}
}
