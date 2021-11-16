package modelo;

import org.junit.jupiter.api.Test;

import dto.ProductoDTO;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;

public class ProductoTest {

	@DisplayName("Insercion Producto null")
	@Test
	public void testInsercionProductoNull() {
		ProductoDTO producto= ProductoDTO.instance();
		String rta=producto.insert(null);
		assertNotNull(rta);
	}
}
