package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private TextField correoCampo;
	@FXML
	private PasswordField passField;
	@FXML
	private Button botonInicioSesion;
	@FXML
	private Label etiquetaCrearCuenta;
	@FXML
	private Button crearCuenta;
	@FXML
	private Button volver;

	// Event Listener on Button[#botonInicioSesion].onAction
	public String DatosUsuario[] = new String[4];
	
	@FXML
	public void volver(ActionEvent event) {
		loadStage("/vista/Menu.fxml");
	}

	@SuppressWarnings("unused")
	@FXML
	public void validaUsuario(ActionEvent event) {
		testMySQLDriver();

		try {

			String url = "jdbc:mysql://localhost:3306/tienda";
			String username = "root";
			String password = "Bases2021";

			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			if (!correoCampo.getText().isEmpty() && !passField.getText().isEmpty()) {

				String usuario = correoCampo.getText();
				String pass = passField.getText();
				CallableStatement cstmt = connection.prepareCall("{call existe_usuario(?, ?, ?)}");
				cstmt.setString(1, usuario);
				cstmt.setString(2, pass);
				cstmt.registerOutParameter(3, java.sql.Types.TINYINT);
				cstmt.execute();
				System.out.println(cstmt.getInt(3));
				
				switch (cstmt.getInt(3)) {
				case 1:
					loadStage("/vista/PaginaUsuario.fxml", event);
					break;
				case 2:
					loadStage("/vista/PaginaVendedor.fxml", event);
					break;
				default:
					JOptionPane.showMessageDialog(null,
							"Error al iniciar sesion, Sus datos de acceso son incorrectos", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					break;
				}
				
				cstmt.close();
			} else {
				JOptionPane.showMessageDialog(null, "Error al iniciar sesion, Introduce datos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
			
			statement.close();
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@FXML
	public void registrarUsuario(ActionEvent event) {
		loadStage("/vista/RegistrarUsuario.fxml");
	}

	@SuppressWarnings("deprecation")
	private static void testMySQLDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
		}
	}

	private void loadStage(String URL, Event event) {
		try {
			Object eventSource = event.getSource();
			Node sourceAsNode = (Node) eventSource;
			Scene viejaEscena = sourceAsNode.getScene();
			Window ventana = viejaEscena.getWindow();
			Stage stage = (Stage) ventana;

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(URL));
			Scene escena = new Scene(root);
			stage.centerOnScreen();
			stage.setScene(escena);

		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	private void loadStage(String URL) {
		try {
			Stage stage = (Stage) crearCuenta.getScene().getWindow();

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(URL));
			Scene escena = new Scene(root);
			stage.centerOnScreen();
			stage.setScene(escena);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
