package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Conexion {

	private static final String DRIVER_JDBC = "com.mysql.jdbc.Dirver";
	private static final String DB = "proveedor";
	private static final String URL_JDBC = "jdbc:mysql://localhost:3306/" + DB;
	private static final String USER_JDBC = "root";
	private static final String PASSWORD_JDBC = "1234";
	private static Driver driver;

	public synchronized static Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(DRIVER_JDBC);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println("Error" + e.getMessage());
			}
		}
		return DriverManager.getConnection(URL_JDBC, USER_JDBC, PASSWORD_JDBC);
	}

	public static void closed(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {

		}
	}

	public static void closed(PreparedStatement rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
	}

	public static void closed(Connection rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {

		}
	}
}
