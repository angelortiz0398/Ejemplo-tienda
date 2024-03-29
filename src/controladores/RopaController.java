package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;

public class RopaController {
	@FXML
	private SplitPane ropa;
	@FXML
	private CheckBox cBlusa;
	@FXML
	private CheckBox cChamarra;
	@FXML
	private CheckBox cPlayera;
	@FXML
	private CheckBox cCaballero;
	@FXML
	private CheckBox cDama;
	@FXML
	private CheckBox cNinio;
	@FXML
	private CheckBox cNinia;
	@FXML
	private CheckBox cAdidas;
	@FXML
	private CheckBox cNike;
	@FXML
	private CheckBox cPuma;
	@FXML
	private CheckBox cEverlast;
	@FXML
	private CheckBox cKswiss;
	@FXML
	private CheckBox cLevi;
	@FXML
	private CheckBox cLotto;
	@FXML
	private CheckBox cNatural;
	@FXML
	private CheckBox c300;
	@FXML
	private CheckBox c600;
	@FXML
	private CheckBox c900;
	@FXML
	private CheckBox c1000;
	@FXML
	private Button volver;
	@FXML
	private ImageView R16;
	@FXML
	private ImageView R17;
	@FXML
	private ImageView R18;
	@FXML
	private ImageView R19;
	@FXML
	private ImageView R20;
	@FXML
	private ImageView R21;
	@FXML
	private ImageView R22;
	@FXML
	private ImageView R23;
	@FXML
	private ImageView R24;
	@FXML
	private ImageView R25;
	@FXML
	private ImageView R26;
	@FXML
	private ImageView R27;
	@FXML
	private ImageView R28;
	@FXML
	private ImageView R29;
	@FXML
	private ImageView R30;

	// Event Listener on CheckBox[#cBlusa].onAction
	@FXML
	public void soloBlusa(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cChamarra].onAction
	@FXML
	public void soloChamarra(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cPlayera].onAction
	@FXML
	public void soloPlayera(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cCaballero].onAction
	@FXML
	public void soloCaballero(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cDama].onAction
	@FXML
	public void soloDama(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cNinio].onAction
	@FXML
	public void soloNinio(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cNinia].onAction
	@FXML
	public void soloNinia(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cAdidas].onAction
	@FXML
	public void soloAdidas(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cNike].onAction
	@FXML
	public void soloNike(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cPuma].onAction
	@FXML
	public void soloPuma(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cEverlast].onAction
	@FXML
	public void soloEverlast(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cKswiss].onAction
	@FXML
	public void soloKswiss(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cLevi].onAction
	@FXML
	public void soloLevi(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cLotto].onAction
	@FXML
	public void soloLotto(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#cNatural].onAction
	@FXML
	public void soloNatural(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#c300].onAction
	@FXML
	public void solo300(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#c600].onAction
	@FXML
	public void solo600(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#c900].onAction
	@FXML
	public void solo900(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on CheckBox[#c1000].onAction
	@FXML
	public void solo1000(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#volver].onAction
	@FXML
	public void presionaVolver(ActionEvent event) {
		try {
			loadStage("/vista/Menu.fxml", event);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Event Listener on ImageView[#R16].onMouseClicked
	@FXML
	public void presionaR16(MouseEvent event) {
		try {
			Stage popupwindow = new Stage();
			popupwindow.initModality(Modality.APPLICATION_MODAL);
			popupwindow.setTitle("");
			Label label1 = new Label("�Desea agregar al carrito?");
			Button button1 = new Button("Agregar");
			button1.setOnAction(e -> popupwindow.close());
			VBox layout = new VBox(10);
			layout.getChildren().addAll(label1, button1);
			layout.setAlignment(Pos.CENTER);
			Scene scene1 = new Scene(layout, 250, 150);
			popupwindow.setScene(scene1);
			popupwindow.showAndWait();

		} catch (Exception e) {
			// logger.debug(e.toString());
		}
	}

	// Event Listener on ImageView[#R17].onMouseClicked
	@FXML
	public void presionaR17(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R18].onMouseClicked
	@FXML
	public void presionaR18(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R19].onMouseClicked
	@FXML
	public void presionaR19(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R20].onMouseClicked
	@FXML
	public void presionaR20(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R21].onMouseClicked
	@FXML
	public void presionaR21(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R22].onMouseClicked
	@FXML
	public void presionaR22(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R23].onMouseClicked
	@FXML
	public void presionaR23(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R24].onMouseClicked
	@FXML
	public void presionaR24(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R25].onMouseClicked
	@FXML
	public void presionaR25(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R26].onMouseClicked
	@FXML
	public void presionaR26(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R27].onMouseClicked
	@FXML
	public void presionaR27(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R28].onMouseClicked
	@FXML
	public void presionaR28(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R29].onMouseClicked
	@FXML
	public void presionaR29(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on ImageView[#R30].onMouseClicked
	@FXML
	public void presionaR30(MouseEvent event) {
		// TODO Autogenerated
	}

	private void loadStage(String URL, Event event) {
		try {
			// ((Node) (event.getSource())).getScene().getWindow().hide();

			Object eventSource = event.getSource();
			Node sourceAsNode = (Node) eventSource;
			Scene viejaEscena = sourceAsNode.getScene();
			Window ventana = viejaEscena.getWindow();
			Stage stage = (Stage) ventana;

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(URL));
			Scene escena = new Scene(root);
			stage.centerOnScreen();
			stage.setScene(escena);
		} catch (IOException e) {
			// TODO: handle exception
			// Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
