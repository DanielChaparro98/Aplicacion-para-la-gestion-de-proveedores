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
	private final String INSERT_SQL="INSERT INTO PROVEEDOR (nit,nombre,telefono,id_producto) VALUES (?,?,?,?)";
	private final String UPDATE_SQL="UPDATE proveedor SET nit=?,nombre=? ,telefono=? , id_producto=? WHERE id=?";
	private final String DELETE_SQL="DELETE FROM proveedor WHERE id=?";
	private final String SELECT_SQL="SELECT * FROM PROVEEDOR ";
	private final String SELECT_ONE="SELECT * FROM PROVEEDOR WHERE id=?";
	private final String SELECT_NIT="SELECT * FROM PROVEEDOR WHERE nit=?";
	
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
		if(proveedor==null|| proveedor.getId()==null && proveedor.getNit()==null && proveedor.getNombre()==null && proveedor.getTelefono()==null) {
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
			stmt.setString(index++, proveedor.getNit());
			stmt.setString(index++, proveedor.getNombre());
			stmt.setString(index++, proveedor.getTelefono());
			stmt.setLong(index++,proveedor.getIdProducto().getId());
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
		if(proveedor==null|| proveedor.getId()==null && proveedor.getNit()==null && proveedor.getNombre()==null && proveedor.getTelefono()==null) {
			return "No se inserto ningun dato";
		}
		String mensaje="";
		Connection conn=null;
		PreparedStatement stmt=null;
		int row=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(UPDATE_SQL);
			int index=1;
			stmt.setString(index++, proveedor.getNit());
			stmt.setString(index++, proveedor.getNombre());
			stmt.setString(index++, proveedor.getTelefono());
			stmt.setLong(index++,proveedor.getIdProducto().getId());
			stmt.setLong(index++, proveedor.getId());
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
			stmt.setLong(index++,id);
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
				proveedor.setIdProducto(ProductoDTO.instance().selectProducto(rs.getLong(5)));
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
	
		public Proveedor selectProveedor(Long id) {
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Proveedor proveedor=null;
			try {
				conn=Conexion.getConnection();
				stmt=conn.prepareStatement(SELECT_ONE);
				stmt.setLong(1, id);
				rs=stmt.executeQuery();
				while(rs.next()) {
					proveedor= new Proveedor();
					proveedor.setId(rs.getLong(1));
					proveedor.setNit(rs.getString(2));
					proveedor.setNombre(rs.getString(3));
					proveedor.setTelefono(rs.getString(4));
					proveedor.setIdProducto(ProductoDTO.instance().selectProducto(rs.getLong(5)));
				}
			}catch(SQLException e) {
				System.out.println("Error"+e.getMessage());
			}finally {
				Conexion.closed(conn);
				Conexion.closed(stmt);
				Conexion.closed(rs);
			}
			return proveedor;
		}
		
		
		public Proveedor selectProveedorNit(String Nit) {
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Proveedor proveedor=null;
			try {
				conn=Conexion.getConnection();
				stmt=conn.prepareStatement(SELECT_NIT);
				stmt.setString(1, Nit);
				rs=stmt.executeQuery();
				while(rs.next()) {
					proveedor= new Proveedor();
					proveedor.setId(rs.getLong(1));
					proveedor.setNit(rs.getString(2));
					proveedor.setNombre(rs.getString(3));
					proveedor.setTelefono(rs.getString(4));
					proveedor.setIdProducto(ProductoDTO.instance().selectProducto(rs.getLong(5)));
				}
			}catch(SQLException e) {
				System.out.println("Error"+e.getMessage());
			}finally {
				Conexion.closed(conn);
				Conexion.closed(stmt);
				Conexion.closed(rs);
			}
			return proveedor;
		}
}
