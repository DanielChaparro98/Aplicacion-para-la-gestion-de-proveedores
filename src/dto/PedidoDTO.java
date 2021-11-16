package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;
import services.Conexion;

public class PedidoDTO {

	private final String INSERT_SQL="INSERT INTO PEDIDO (id,cantidadProductos,estado,fechaEntrega) VALUES (?,?,?,?)";
	private final String UPDATE_SQL="UPDATE PEDIDO SET cantidadProductos=? ,estado=? , fechaEntrega=? WHERE id=?";
	private final String DELETE_SQL="DELETE FROM PEDIDO WHERE id=?";
	private final String SELECT_SQL="SELECT id,cantidadProductos,estado,fechaEntrega WHERE id=?";
	private static PedidoDTO pedidoDto;
	
	private PedidoDTO() {
		
	}
	
	public static PedidoDTO instance() {
		if(pedidoDto==null) {
			pedidoDto= new PedidoDTO();
		}
		return pedidoDto;
	}
	
	public String insert(Pedido pedido) {
		if(pedido==null || (pedido.getId()==null && pedido.getCantidadProductos()==null && pedido.getEstado()==null && pedido.getFechaEntrega()==null)) {
			String mensaje="";
			return mensaje="No se inserto ningun dato";
		}
		
		if(pedido.getId()==null) {
		return "El id del pedido no existe";		
		}
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			int index = 1;
			stmt.setLong(index++, pedido.getId());
			stmt.setLong(index++, pedido.getCantidadProductos());
			stmt.setString(index++, pedido.getEstado());
			stmt.setDate(index++, pedido.getFechaEntrega());
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
		if(pedido==null || (pedido.getId()==null && pedido.getCantidadProductos()==null && pedido.getEstado()==null && pedido.getFechaEntrega()==null)) {
			String mensaje="";
			return mensaje="No se inserto ningun dato";
		}
		String mensaje="";
		Connection conn=null;
		PreparedStatement stmt=null;
		int row=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(UPDATE_SQL);
			int index=1;
			stmt.setLong(index++, pedido.getId());
			stmt.setLong(index++, pedido.getCantidadProductos());
			stmt.setString(index++, pedido.getEstado());
			stmt.setDate(index, pedido.getFechaEntrega());
			row=stmt.executeUpdate();
			mensaje="Se actualizo"+row+"registro satisfactoriamente";
			
			
		}catch(SQLException e) {
			mensaje="Error"+e.getMessage();
		}finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}
		return mensaje;
	}
	
	public String deleted(Long id) {
		if(id==null) {
			return "No ha ingresado un id";
		}
		String mensaje="";
		Connection conn=null;
		PreparedStatement stmt=null;
		int row=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(DELETE_SQL);
			int index=1;
			stmt.setLong(index++, id);
			row=stmt.executeUpdate();
			mensaje="Se elimino"+row+"registro satisfactorio";
		}catch (SQLException e) {
			mensaje="Erro"+e.getMessage();
		}finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
		}
		
		return mensaje;
	}
	
	public List<Pedido> select(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Pedido pedido=null;
		List<Pedido> lista= new ArrayList<>();
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SELECT_SQL);
			rs=stmt.executeQuery();
			while(rs.next()) {
				pedido=new Pedido();
				pedido.setId(rs.getLong(1));
				pedido.setCantidadProductos(rs.getLong(2));
				pedido.setEstado(rs.getString(3));
				pedido.setFechaEntrega(rs.getDate(4));
				lista.add(pedido);
			}
			} catch (SQLException e) {
				System.out.println("Error "+e.getMessage());
			}finally {
				Conexion.closed(conn);
				Conexion.closed(stmt);
				Conexion.closed(rs);
			}
			return lista;
		}
	
	}


