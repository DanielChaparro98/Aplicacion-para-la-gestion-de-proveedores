package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import services.Conexion;

public class ProductoDTO {
	private final String INSERT_SQL = "INSERT INTO producto (nombre,tipo) VALUES (?,?)";
	private final String UPDATE_SQL = "UPDATE producto SET nombre=? ,tipo=? WHERE id=?";
	private final String DELETE_SQL = "DELETE FROM producto WHERE id=?";
	private final String SELECT_SQL = "SELECT * FROM producto ORDER BY id";
	private final String SELECT_ONE = "SELECT * FROM producto WHERE id=?";
	private final String SELECT_NOMBRE="SELECT * FROM producto WHERE nombre=?";
	private static ProductoDTO productoDto;

	private ProductoDTO() {

	}

	public static ProductoDTO instance() {
		if (productoDto == null) {
			productoDto = new ProductoDTO();
		}
		return productoDto;
	}

	public String insert(Producto producto) {
		if (producto == null
				|| (producto.getId() == null && producto.getNombre() == null && producto.getTipo() == null)) {
			return "No se inserto ningun dato";
		}
//		if (producto.getId() == null) {
//			return "El id del pedido no exste";
//		}
		String mensaje = "";
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			int index = 1;
			//stmt.setLong(index++, producto.getId());
			stmt.setString(index++, producto.getNombre());
			stmt.setString(index++, producto.getTipo());
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

	public String update(Producto producto) {
		if (producto == null
				|| (producto.getId() == null && producto.getNombre() == null && producto.getTipo() == null)) {
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
			stmt.setString(index++, producto.getNombre());
			stmt.setString(index++, producto.getTipo());
			stmt.setLong(index++, producto.getId());
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

	public List<Producto> select() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto producto = null;
		List<Producto> lista = new ArrayList<>();
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getLong(1));
				producto.setNombre(rs.getString(2));
				producto.setTipo(rs.getString(3));
				lista.add(producto);
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

	public Producto selectProducto(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getLong(1));
				producto.setNombre(rs.getString(2));
				producto.setTipo(rs.getString(3));

			}
		} catch (SQLException e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
			Conexion.closed(rs);

		}
		return producto;
	}

	public Producto selectProductoNombre(String nombre) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_NOMBRE);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getLong(1));
				producto.setNombre(rs.getString(2));
				producto.setTipo(rs.getString(3));

			}
		} catch (SQLException e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			Conexion.closed(conn);
			Conexion.closed(stmt);
			Conexion.closed(rs);

		}
		return producto;
	}
	
}
