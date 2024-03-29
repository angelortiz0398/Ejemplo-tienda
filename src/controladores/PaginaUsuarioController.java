package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Conexion.Conexion;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class PaginaUsuarioController implements Initializable {
	@FXML
	private Button botonPedidos;
	@FXML
	private Button botonFacturas;
	@FXML
	private Button botonVendedores;
	@FXML
	private Button Datos;
	@FXML
	private Button botonActualizar;
	@FXML
	private Button volver;
	@FXML
	private Label privacidad;
	@FXML
	private Label terminos;
	@FXML
	private TableView<Usuario> tabla;
	@FXML
	private TableColumn<Usuario, String> Nombre;
	@FXML
	private TableColumn<Usuario, String> Email;
	@FXML
	private TableColumn<Usuario, String> Password;
	@FXML
	private TableColumn<Usuario, String> Direccion;
	@FXML
	private TableColumn<Usuario, String> Accion;
	@FXML
	private Button ActualizarBoton;

	// Event Listener on Button[#botonPedidos].onAction
	@FXML
	public void presionaPedidos(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#botonFacturas].onAction
	@FXML
	public void presionaFacturas(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#botonVendedores].onAction
	@FXML
	public void presionaVendedores(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#Datos].onAction
	@FXML
	public void verDatos(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#botonActualizar].onAction
	@FXML
	public void presionaActualizar(ActionEvent event) {
		// TODO Autogenerated
		try {
			Conexion cnn = new Conexion();
			this.tabla.setItems(cnn.solicitar_vendedores());
			this.tabla.getItems().addAll(cnn.solicitar_vendedores());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la base de datos");
		}
	}

	// Event Listener on Button[#volver].onAction
	@FXML
	public void presionaVolver(ActionEvent event) {
		// TODO Autogenerated
		loadStage("/vista/Menu.fxml", event);
	}

	// Event Listener on Label[#privacidad].onMouseClicked
	@FXML
	public void presionaPrivacidad(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Label[#terminos].onMouseClicked
	@FXML
	public void presionaTerminos(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#ActualizarBoton].onAction
	@FXML
	public void presionaActualizarTabla(ActionEvent event) {

		try {
			Conexion cnn = new Conexion();
			this.tabla.getItems().clear();
			// this.tabla.setItems(cnn.solicitar_vendedores());
			this.tabla.getItems().addAll(cnn.solicitar_vendedores());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la base de datos");
		}
	}

	public void Actualizar() {
		try {
			Conexion cnn = new Conexion();
			// this.tabla.setItems(cnn.solicitar_vendedores());
			this.tabla.getItems().clear();
			this.tabla.getItems().addAll(cnn.solicitar_vendedores());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la base de datos " + e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.Email.setCellValueFactory(new PropertyValueFactory<>("email"));
		this.Password.setCellValueFactory(new PropertyValueFactory<>("passwd"));
		this.Direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		Callback<TableColumn<Usuario, String>, TableCell<Usuario, String>> celda = (
				TableColumn<Usuario, String> parametros) -> {
			final TableCell<Usuario, String> cell = new TableCell<Usuario, String>() {

				@Override
				protected void updateItem(String arg0, boolean arg1) {
					// TODO Auto-generated method stub
					super.updateItem(arg0, arg1);
					if (arg1) {
						setGraphic(null);
						setText(null);
					} else {
						FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
						FontAwesomeIconView modificarIcono = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE_ALT);
						borrarIcono.setGlyphStyle("fx-cursor:hand;-glyph-size:28px;");
						modificarIcono.setGlyphStyle("fx-cursor:hand;-glyph-size:28px;");
						borrarIcono.setOnMouseClicked((MouseEvent evento) -> {

							Usuario usuario = tabla.getSelectionModel().getSelectedItem();
							try {
								eliminar_vendedores(usuario.getNombre(), usuario.getEmail(), usuario.getDireccion());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
						modificarIcono.setOnMouseClicked((MouseEvent evento) -> {
							Usuario usuario = tabla.getSelectionModel().getSelectedItem();
							Conexion cnn = new Conexion();
							try {
								int idusuario = cnn.obten_IDusuario(usuario.getNombre(), usuario.getEmail(),
										usuario.getDireccion());
								modificar_vendedores(idusuario);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
						HBox hbox = new HBox(borrarIcono, modificarIcono);
						hbox.setStyle("-fx-alligment:center");
						HBox.setMargin(borrarIcono, new Insets(2, 2, 0, 3));
						HBox.setMargin(modificarIcono, new Insets(2, 3, 0, 2));
						setGraphic(hbox);
						setText(null);
					}
				}
			};

			return cell;
		};
		this.Accion.setCellFactory(celda);
		this.Actualizar();

	}

	private void eliminar_vendedores(String nombre, String email, String direccion) throws Exception {
		try {
			Conexion cnn = new Conexion();
			cnn.eliminar_vendedor(nombre, email, direccion);
			this.Actualizar();
		} catch (Exception e) {
			System.out.println("Error en la base de datos");
		}
	}


	private void modificar_vendedores(int idUsuario) throws SQLException {
		String nuevoNombre, nuevoEmail, nuevaDireccion;
		@SuppressWarnings("unused")
		Object resp = JOptionPane.showInputDialog(null, "Estos son los datos que se van a cambiar", "Datos a cambiar",
				JOptionPane.INFORMATION_MESSAGE, null,
				new Object[] { nuevoNombre = JOptionPane.showInputDialog(null, "Coloque el nuevo nombre", ""),
						nuevoEmail = JOptionPane.showInputDialog(null, "Coloque el nuevo email", ""),
						nuevaDireccion = JOptionPane.showInputDialog(null, "Coloque la nueva direccion", "") },
				"Opci�n 2");
		try {
			Conexion cnn = new Conexion();
			cnn.modificar_vendedor(nuevoNombre, nuevoEmail, nuevaDireccion, idUsuario);
			this.Actualizar();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	// Cambia de escenario
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
			// TODO: handle exception2

		}
	}
}
