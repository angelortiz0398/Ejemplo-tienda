package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

    public static void main(String[] args) {

        testMySQLDriver();
        
        try {

            String url = "jdbc:mysql://localhost:3306/tienda";
            String username = "root";
            String password = "Bases2021";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");

            while (rs.next()) {

                int idusuario = rs.getInt("idusuario");
                int idrol = rs.getInt("idrol");
                String nombre = rs.getString("nombre");
                String tipo_documento = rs.getString("tipo_documento");
                String direccion = rs.getString("direccion");

                System.out.println(String.format("%d, %d, %s, %s, %s", idusuario,idrol, nombre, tipo_documento, direccion));
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("deprecation")
	private static void testMySQLDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }
    }


}
