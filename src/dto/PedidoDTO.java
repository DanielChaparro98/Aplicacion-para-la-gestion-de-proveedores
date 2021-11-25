package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;
import modelo.Proveedor;
import services.Conexion;

public class PedidoDTO {

	private final String INSERT_SQL = "INSERT INTO PEDIDO (cantidad_productos,estado,fecha_entrega,motivo,id_proveedor) VALUES (?,?,?,?,?)";
	private final String UPDATE_SQL = "UPDATE PEDIDO SET estado=? , fecha_entrega=?,motivo=? WHERE id=?";
	private final String UPDATE_SQL_C = "UPDATE PEDIDO SET estado=?,motivo=? WHERE id=?";
	private final String DELETE_SQL = "DELETE FROM PEDIDO WHERE id=?";
	private final String SELECT_SQL = "SELECT * FROM PEDIDO ORDER BY id";
	private final String SELECT_ONE = "SELECT * FROM PEDIDO WHERE id=?";
	
	private static PedidoDTO pedidoDto;

	private PedidoDTO() {

	}

	public static PedidoDTO instance() {
		if (pedidoDto == null) {
			pedidoDto = new PedidoDTO();
		}
		return pedidoDto;
	}

	public String insert(Pedido pedido) {
		if (pedido == null || (pedido.getId() == null && pedido.getCantidadProductos() == null
				&& pedido.getEstado() == null && pedido.getFechaEntrega() == null)) {

			return "No se inserto ningun dato";
		}
		
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			int index = 1;
			stmt.setLong(index++, pedido.getCantidadProductos());
			stmt.setString(index++, pedido.getEstado());
			stmt.setDate(index++, pedido.getFechaEntrega());
			stmt.setString(index++,pedido.getMotivo());
			stmt.setLong(index++,pedido.getIdProveedor().getId());
			row = stmt.executeUpdate();
			mensaje = "se inserto" + row + "registro satisfactoriamente";

		} catch (SQLException e) {
			mensaje = "Error" + e.getMessage();
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}

		return mensaje;
	}

	public String update(Pedido pedido) {
		if (pedido == null || (pedido.getId() == null && pedido.getCantidadProductos() == null
				&& pedido.getEstado() == null && pedido.getFechaEntrega() == null)) {
			return "No se inserto ningun dato";
		}
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(UPDATE_SQL);
			int index = 1;
			stmt.setString(index++, pedido.getEstado());
			stmt.setDate(index++, pedido.getFechaEntrega());
			stmt.setString(index++, pedido.getMotivo());
			stmt.setLong(index++, pedido.getId());
			row = stmt.executeUpdate();
			mensaje = "Se actualizo" + row + "registro satisfactoriamente";

		} catch (SQLException e) {
			mensaje = "Error" + e.getMessage();
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}
		return mensaje;
	}
	
	
	public String updateCancelacion(Pedido pedido) {
		if (pedido == null || (pedido.getId() == null && pedido.getCantidadProductos() == null
				&& pedido.getEstado() == null && pedido.getFechaEntrega() == null)) {
			return "No se inserto ningun dato";
		}
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(UPDATE_SQL_C);
			int index = 1;
			stmt.setString(index++, pedido.getEstado());
			stmt.setString(index++, pedido.getMotivo());
			stmt.setLong(index++, pedido.getId());
			row = stmt.executeUpdate();
			mensaje = "Se actualizo" + row + "registro satisfactoriamente";

		} catch (SQLException e) {
			mensaje = "Error" + e.getMessage();
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}
		return mensaje;
	}

	public String deleted(Long id) {
		if (id == null) {
			return "No ha ingresado un id";
		}
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(DELETE_SQL);
			int index = 1;
			stmt.setLong(index++, id);
			row = stmt.executeUpdate();
			mensaje = "Se elimino" + row + "registro satisfactorio";
		} catch (SQLException e) {
			mensaje = "Erro" + e.getMessage();
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}

		return mensaje;
	}

	public List<Pedido> select() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pedido pedido = null;
		List<Pedido> lista = new ArrayList<>();
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pedido = new Pedido();
				pedido.setId(rs.getLong(1));
				pedido.setCantidadProductos(rs.getLong(2));
				pedido.setEstado(rs.getString(3));
				pedido.setFechaEntrega(rs.getDate(4));
				pedido.setMotivo(rs.getString(5));
				pedido.setIdProveedor(ProveedorDTO.instance().selectProveedor(rs.getLong(6)));
				lista.add(pedido);
			}
		} catch (SQLException e) {
			System.out.println("Error " + e.getMessage());
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
			Conexion.closed(rs);
		}
		return lista;
	}
	
	public Pedido selectPedido(Long id) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Pedido pedido=null;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SELECT_ONE);
			stmt.setLong(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				pedido= new Pedido();
				pedido.setId(rs.getLong(1));
				pedido.setCantidadProductos(rs.getLong(2));
				pedido.setEstado(rs.getString(3));
				pedido.setFechaEntrega(rs.getDate(4));
				pedido.setMotivo(rs.getString(5));
				pedido.setIdProveedor(ProveedorDTO.instance().selectProveedor(rs.getLong(6)));
			}
		}catch(SQLException e) {
			System.out.println("Error "+ e.getMessage());
		}finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
			Conexion.closed(rs);
		}
		
		return pedido;
	}

}
