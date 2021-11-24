package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

import dto.ProductoDTO;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Proveedor;

public class ProductoCtrl {

    private Producto producto;
    private List<Producto> productos;
    private ProductoDTO productoDTO;

    public ProductoCtrl() {
        productos = new ArrayList();
        productoDTO = ProductoDTO.instance();
    }

    public String saveProducto( String nombre, String tipo) {
    	String mensaje="";
    	
    	JOptionPane.showMessageDialog(null, "Producto creado exitosamente");
        producto = new Producto(nombre, tipo);
        mensaje = productoDTO.insert(producto);
        
        return mensaje;
    }

    public String updateProducto(Long id, String nombre, String tipo) {
        producto = new Producto(id, nombre, tipo);
        String mensaje = productoDTO.update(producto);
        JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
        return mensaje;
    }

    public String deleteProducto(Long id) {
        String mensaje = productoDTO.deleted(id);
        JOptionPane.showMessageDialog(null,"Producto eliminado exitosamente");
        return mensaje;
    }

    public List<Producto> selectProducto() {
        productos = productoDTO.select();
        return productos;
    }

    public Producto selectProducto(Long id) {
    	producto= productoDTO.selectProducto(id);
    	return producto;
    }
    
    public Producto selectProductoNombre(String nombre) {
    	producto=productoDTO.selectProductoNombre(nombre);
    	return producto;
    }
    
    public DefaultTableModel tablaProducto() {
        DefaultTableModel model = new DefaultTableModel();
        List<Producto> productos = selectProducto();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        for (Producto producto : productos) {
            Object[] fila = new Object[3];
            fila[0] = producto.getId();
            fila[1] = producto.getNombre();
            fila[2] = producto.getTipo();
            model.addRow(fila);
        }

        return model;
    }

}
