package db;


import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import services.Conexion;

public class ConexionTest {

	@DisplayName("Pruebas de conexion")
	@Test
	public void testPruebasConexion() throws SQLException {
		Connection con= Conexion.getConnection();
		assertNotNull(con);
	}
}
