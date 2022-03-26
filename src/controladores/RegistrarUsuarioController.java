package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.PasswordField;

import javafx.scene.control.DatePicker;

public class RegistrarUsuarioController {
	@FXML
	private TextField nombre;
	@FXML
	private TextField apellidos;
	@FXML
	private TextField correo;
	@FXML
	private PasswordField password;
	@FXML
	private TextField celular;
	@FXML
	private DatePicker fecha;
	@FXML
	private TextField calle;
	@FXML
	private TextField colonia;
	@FXML
	private TextField municipio;
	@FXML
	private TextField num;
	@FXML
	private TextField estado;
	@FXML
	private Button registrarse;
	@FXML
	private Button volver;
	
	@FXML 
	public void presionarVolver(ActionEvent event) {
		loadStage("/vista/Menu.fxml", event);
	}

	// Event Listener on Button[#registrarse].onAction
	@FXML
	public void registrar(ActionEvent event) {
		// Creacion de Cadenas de texto temporales que almacenen los campos del formulario
		String nombreCompleto = nombre.getText() + " " + apellidos.getText();
		String direccion = calle.getText() + " " + num.getText() + ", " + colonia.getText() + ", " + municipio.getText() + ", "+ estado.getText();
		
		// Creacion de un usuario y se le propocionaran los datos del formulario.
		Usuario user = new Usuario();
		user.setNombre(nombreCompleto);
		user.setEmail(correo.getText());
		user.setPasswd(password.getText());
		user.setTelefono(celular.getText());
		user.setDireccion(direccion);
		
		// Conexion de la base de datos
		testMySQLDriver();
		try {
			String url = "jdbc:mysql://localhost:3306/tienda";
			String username = "root";
			String password = "Bases2021";

			Connection connection = DriverManager.getConnection(url, username, password);
			
		// INSERT en la tabla usuario	
			CallableStatement cstmt = connection.prepareCall("{call crear_vendedor(?, ?, ?, ?, ?)}");
			cstmt.setString(1, user.getNombre());
			cstmt.setString(2, user.getDireccion());
			cstmt.setString(3, user.getTelefono());
			cstmt.setString(4, user.getEmail());
			cstmt.setString(5, user.getPasswd());
			cstmt.execute();
		// Cerramos la base de datos	
			cstmt.close();
			connection.close();
			loadStage("/vista/Menu.fxml");
		} catch (Exception e) {
			// TODO: handle exception
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
	
	@SuppressWarnings("unused")
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
			Stage stage = (Stage) registrarse.getScene().getWindow();

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
