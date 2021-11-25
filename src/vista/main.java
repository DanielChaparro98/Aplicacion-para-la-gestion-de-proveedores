package vista;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import controlador.PedidoCtrl;
import controlador.ProductoCtrl;
import controlador.ProveedorCtrl;
import dto.PedidoDTO;
import dto.ProductoDTO;
import dto.ProveedorDTO;
import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;

public class main {

	public static void main(String[] args) {
		
		  
		
		ProductoCtrl producto= new ProductoCtrl();
		//producto.saveProducto("pedsasde","dasds");
		Producto producto1=producto.selectProducto(2L);
//		System.out.println(producto1.toString());
//		List<Producto> productos=producto.selectProducto();
//		for (Producto producto2 : productos) {
//			System.out.println(producto2.toString());
//		}
		
		ProveedorCtrl proveedor = new ProveedorCtrl();
		ProveedorDTO dto= ProveedorDTO.instance();
		//proveedor.saveProveedor("", "", "", producto1);
//		proveedor.updateProveedor(1L, "245325", "nombre9", "34534", producto1);
	//dto.deleted(1L);
		//proveedor.deleteProveedor(1L);
		Proveedor proveedord= proveedor.selectProveedor(11L);
				//proveedor.selectProveedorNit("245325");
//		for (Proveedor proveedor2 : proveedord) {
//			System.out.println(proveedor2.toString());
//		}
		
//		for(Proveedor proveedor2:proveedores) {
//			System.out.println(proveedor2.toString());
//		}
		
//		Date date= new Date(122,5,3);
//		Date datePrueba=producto.getRandomDate();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String format=simpleDateFormat.format(date);
//        java.sql.Date sql= new  java.sql.Date(datePrueba.getTime());
//        System.out.println(sql.toString());
		
		Random rand = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 0, 1);
		long start = cal.getTimeInMillis();
		cal.set(2021, 10, 1);
		long end = cal.getTimeInMillis();
		Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
		java.sql.Date sql= new  java.sql.Date(d.getTime());
		
	PedidoDTO pedidoDto= PedidoDTO.instance();
	PedidoCtrl pedido= new PedidoCtrl();
	pedido.savePedido(1L, "", sql,"" ,proveedord);
    //pedido.updatePedido(1L, "Aplazado", sql, "Porque si");
	List<Pedido> pedidos=pedido.selectPedido();
    
	for (Pedido pedido2 : pedidos) {
		System.out.println(pedido2.toString());
	}
		
		
//		CREATE TABLE proveedor(id BIGINT AUTO_INCREMENT PRIMARY KEY,nit VARCHAR(50),nombre VARCHAR(50),telefono VARCHAR(50),id_producto BIGINT,FOREIGN KEY (id_producto) REFERENCES producto(id) ON DELETE CASCADE)
	}
}
