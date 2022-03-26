package Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Conexion {

	public Conexion() {
		// TODO Auto-generated constructor stub

	}

	public ObservableList<Usuario> solicitar_vendedores() throws SQLException {

		ObservableList<Usuario> lista = FXCollections.observableArrayList();
		String url = "jdbc:mysql://localhost:3306/tienda";
		String username = "root";
		String password = "Bases2021";
		Connection conexion = DriverManager.getConnection(url, username, password);
		String queryString = "call solicitar_vendedores()";
		CallableStatement solicitud = conexion.prepareCall(queryString);
		solicitud.execute();
		ResultSet datoSet = solicitud.executeQuery();

		if (!datoSet.next()) {
			System.out.println("No hay datos");
		} else {
			do {
				Usuario u1 = new Usuario();
				u1.setNombre(datoSet.getString(1));
				u1.setEmail(datoSet.getString(2));
				u1.setPasswd(datoSet.getString(3));
				u1.setDireccion(datoSet.getString(4));
				lista.add(u1);
			} while (datoSet.next());
			solicitud.close();
			datoSet.close();
			conexion.close();
		}
		return lista;
	}

	public void eliminar_vendedor(String nombre, String email, String direccion) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tienda";
		String username = "root";
		String password = "Bases2021";
		Connection conexion = DriverManager.getConnection(url, username, password);
		String queryString = "{call eliminar_vendedor(?,?,?)}";
		CallableStatement solicitud = conexion.prepareCall(queryString);
		solicitud.setString(1, nombre);
		solicitud.setString(2, email);
		solicitud.setString(3, direccion);
		solicitud.execute();
		solicitud.close();
		conexion.close();
	}

	public void modificar_vendedor(String nombre, String email, String direccion, int id) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tienda";
		String username = "root";
		String password = "Bases2021";
		Connection conexion = DriverManager.getConnection(url, username, password);
		String queryString = "{call modificar_vendedor(?,?,?,?)};";
		CallableStatement solicitud = conexion.prepareCall(queryString);
		solicitud.setString(1, nombre);
		solicitud.setString(2, email);
		solicitud.setString(3, direccion);
		solicitud.setInt(4, id);
		solicitud.execute();
		solicitud.close();
		conexion.close();
	}

	public int obten_IDusuario(String nombre, String email, String direccion) {
		int id = 0;
		try {

			String url = "jdbc:mysql://localhost:3306/tienda";
			String username = "root";
			String password = "Bases2021";

			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			CallableStatement cstmt = connection.prepareCall("{call obten_IDusuario(?, ?, ?, ?)};");
			cstmt.setString(1, nombre);
			cstmt.setString(2, email);
			cstmt.setString(3, direccion);
			cstmt.registerOutParameter(4, java.sql.Types.TINYINT);
			cstmt.execute();
			id = cstmt.getInt(4);
			cstmt.close();
			statement.close();
			connection.close();
		}
		catch (SQLException ex) {
			System.out.println(ex);
		}
		return id;
	}
}
