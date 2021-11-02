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

public class ProveedorDTO {
	private final String INSERT_SQL="INSERT INTO PEDIDO (id,cantidadproveedors,estado,fechaEntrega) VALUES (?,?,?,?)";
	private final String UPDATE_SQL="UPDATE PEDIDO SET cantidadproveedors=? ,estado=? , fechaEntrega=? WHERE id=?";
	private final String DELETE_SQL="DELETE FROM PEDIDO WHERE id=?";
	private final String SELECT_SQL="SELECT id,cantidadproveedors,estado,fechaEntrega WHERE id=?";
	private static ProveedorDTO proveedorDto;
	
	private ProveedorDTO() {
		
	}
	
	public static ProveedorDTO instance() {
		if(proveedorDto==null) {
			proveedorDto= new ProveedorDTO();
		}
		return proveedorDto;
	}
	
	public String insert(Proveedor proveedor) {
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			int index = 1;
			stmt.setLong(index++, proveedor.getId());
			stmt.setString(index++, proveedor.getNit());
			stmt.setString(index++, proveedor.getNombre());
			stmt.setString(index++, proveedor.getTelefono());
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

	public String update(Proveedor proveedor) {
		String mensaje="";
		Connection conn=null;
		PreparedStatement stmt=null;
		int row=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(UPDATE_SQL);
			int index=1;
			stmt.setLong(index++, proveedor.getId());
			stmt.setString(index++, proveedor.getNit());
			stmt.setString(index++, proveedor.getNombre());
			stmt.setString(index, proveedor.getTelefono());
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
	
	public String deleted(int id) {
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
	
	public List<Proveedor> select(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Proveedor proveedor=null;
		List<Proveedor> lista= new ArrayList<>();
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SELECT_SQL);
			rs=stmt.executeQuery();
			while(rs.next()) {
				proveedor=new Proveedor();
				proveedor.setId(rs.getLong(1));
				proveedor.setNit(rs.getString(2));
				proveedor.setNombre(rs.getString(3));
				proveedor.setTelefono(rs.getString(4));
				lista.add(proveedor);
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
