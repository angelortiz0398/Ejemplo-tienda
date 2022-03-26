package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class TraductorControlador implements Initializable {

	public TraductorControlador() {
		
	}
	@FXML
	private ComboBox<String> cb1;
	@FXML
	private ComboBox<String> cb2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    cb1.getItems().removeAll(cb1.getItems());
	    cb1.getItems().addAll("Español", "Ingles", "Portugues","Frances","Italiano", "Aleman","Ruso","Chino mandarin");
	    cb2.getItems().removeAll(cb2.getItems());
	    cb2.getItems().addAll("Español", "Ingles", "Portugues","Frances","Italiano", "Aleman","Ruso","Chino mandarin");
	    
	}
	
	public void traducir() {
	}


}
