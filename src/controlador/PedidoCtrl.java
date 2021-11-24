package controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dto.PedidoDTO;
import modelo.Pedido;
import modelo.Proveedor;

public class PedidoCtrl {

	private Pedido pedido;
	private List<Pedido> pedidos;
	private PedidoDTO pedidoDTO;

	public PedidoCtrl() {
		pedidos = new ArrayList();
		pedidoDTO = PedidoDTO.instance();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}

	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}

	public String savePedido(Long cantidadProductos, String estado, Date fechaEntrega, Proveedor idProveedor) {
		String mensaje="";
			JOptionPane.showMessageDialog(null, "Pedido creado exitosamente");
			pedido = new Pedido( cantidadProductos, estado, fechaEntrega, idProveedor);
			mensaje = pedidoDTO.insert(pedido);
		

		return mensaje;
	}

	public String updatePedido(Long id, String estado, Date fechaEntrega,String motivo) {
		pedido = new Pedido(id, estado, fechaEntrega,motivo);
		String mensaje = pedidoDTO.update(pedido);
		return mensaje;
	}

	public String updateCancelacion(Long id,String estado,String motivo) {
		pedido= new Pedido(id, estado, motivo);
		String mensaje= pedidoDTO.updateCancelacion(pedido);
		return mensaje;
	}
        
	public String deletePedido(Long id) {
		String mensaje = pedidoDTO.deleted(id);
		return mensaje;
	}

	public List<Pedido> selectPedido() {
		pedidos = pedidoDTO.select();
		return pedidos;
	}
	
	public Pedido selectPedido(Long id) {
		pedido=pedidoDTO.selectPedido(id);
		return pedido;
	}

	public DefaultTableModel tablaPedido() {
		DefaultTableModel model = new DefaultTableModel();
		List<Pedido> pedidos = selectPedido();
		model.addColumn("Id");
		model.addColumn("Cantidad de Productos");
		model.addColumn("Estado");
		model.addColumn("Fecha Entrega");
                model.addColumn("Motivo");
		model.addColumn("Nombre Proveedor");
		for (Pedido pedido : pedidos) {
			Object[] fila = new Object[6];
			fila[0] = pedido.getId();
			fila[1] = pedido.getCantidadProductos();
			fila[2] = pedido.getEstado();
			fila[3] = pedido.getFechaEntrega();
                        fila[4]= pedido.getMotivo();
			fila[5] = pedido.getIdProveedor().getNombre();
			model.addRow(fila);
		}
		return model;
	}
}
