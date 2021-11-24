package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dto.ProveedorDTO;
import java.util.Objects;
import modelo.Producto;
import modelo.Proveedor;

public class ProveedorCtrl {

	private Proveedor proveedor;
	private List<Proveedor> proveedores;
	private ProveedorDTO proveedorDTO;

	public ProveedorCtrl() {
		proveedores = new ArrayList();
		proveedorDTO = ProveedorDTO.instance();

	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	public String saveProveedor(String nombre, String nit, String telefono, Producto idProducto) {
		String mensaje="";
		
		
		proveedor = new Proveedor(nit, nombre, telefono, idProducto);
		JOptionPane.showMessageDialog(null, "Proveedor creado exitosamente");
                mensaje = proveedorDTO.insert(proveedor);
		
		return mensaje;
	}

	public String updateProveedor(Long id, String nombre, String nit, String telefono, Producto idProducto) {
		proveedor = new Proveedor(id, nombre, nit, telefono, idProducto);
		String mensaje = proveedorDTO.update(proveedor);
		JOptionPane.showMessageDialog(null, "Proveedor actualizado con exito");
		return mensaje;
	}

	public String deleteProveedor(Long id) {
		String mensaje = proveedorDTO.deleted(id);
		return mensaje;
	}

	public List<Proveedor> selectProveedor() {
		proveedores = proveedorDTO.select();
		return proveedores;
	}
	
	public Proveedor selectProveedor(Long id) {
		proveedor=proveedorDTO.selectProveedor(id);
		return proveedor;
		
	}
	
	public Proveedor selectProveedorNit(String nit) {
		proveedor=proveedorDTO.selectProveedorNit(nit);
		return proveedor;
	}

	public DefaultTableModel tablaProveedor() {
		DefaultTableModel model = new DefaultTableModel();
		List<Proveedor> proveedores = selectProveedor();
		model.addColumn("Id");
		model.addColumn("NIT");
		model.addColumn("Nombre");
		model.addColumn("Telefono");
		model.addColumn("Producto");
		for (Proveedor proveedor : proveedores) {
			Object[] fila = new Object[5];
			fila[0] = proveedor.getId();
			fila[1] = proveedor.getNit();
			fila[2] = proveedor.getNombre();
			fila[3] = proveedor.getTelefono();
			fila[4] = proveedor.getIdProducto().getNombre();
			model.addRow(fila);
		}

		return model;
	}
	
	

}
