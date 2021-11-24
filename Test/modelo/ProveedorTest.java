package modelo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.ProveedorDTO;

public class ProveedorTest {
	
	@DisplayName("Insercion Proveedor Null")
	@Test
	public void testInsercionProveedorNull() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		String rta=pdto.insert(null);
		assertNotNull(rta);
	}

	@DisplayName("Insercion de Proveedor sin datos")
	@Test
	public void testInsercionProveedorSinDatos() {
		ProveedorDTO pdto= ProveedorDTO.instance();
		Proveedor proveedor= new Proveedor();
		String rta=pdto.insert(proveedor);
		assertNotNull(rta);
	}
	
	@DisplayName("Insercion Proveedor Ok")
	@Test
	public void testInsercionProveedorOk() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		Producto producto= new Producto();
		Proveedor proveedor= new Proveedor();
		producto.setId(1L);
		proveedor.setNit("323232323");
		proveedor.setNombre("Nombre1");
		proveedor.setTelefono("2342423");
		proveedor.setIdProducto(producto);
		String rta=pdto.insert(proveedor);
		assertNotNull(rta);	
	}
	
	@DisplayName("Actualizacion Proveedor sin datos")
	@Test
	public void testActualizacionProveedor() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		Proveedor proveedor = new Proveedor();
		String rta= pdto.update(proveedor);
		assertNotNull(rta);
	}
	
	@DisplayName("Actualizacion Proveedor ok")
	@Test
	public void testActualizacionProveedorOk() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		Proveedor proveedor= new Proveedor();
		Producto producto= new Producto();
		producto.setId(1L);
		proveedor.setNit("1234353");
		proveedor.setNombre("Nombre1");
		proveedor.setTelefono("3234233");
		proveedor.setIdProducto(producto);
		String rta=pdto.insert(proveedor);
		assertNotNull(rta);
	}
	
	@DisplayName("Eliminacion Proveedor sin datos")
	@Test
	public void testEliminacionProveedorSinDatos() {
		ProveedorDTO pdto= ProveedorDTO.instance();
		Proveedor proveedor= new Proveedor();
		String rta= pdto.deleted(proveedor.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Eliminacion Proveedor OK")
	@Test
	public void testEliminacionOk() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		Proveedor proveedor= new Proveedor();
		proveedor.setId(1L);
		String rta =pdto.deleted(proveedor.getId());
		assertNotNull(rta);
	}
	
	@DisplayName("Seleccionar Proveedor")
	@Test
	public void testSeleccionOk() {
		ProveedorDTO pdto=ProveedorDTO.instance();
		List<Proveedor> proveedores=pdto.select();
		assertNotNull(proveedores);
	}

}
