package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class MenuPrincipal extends Application {

	public MenuPrincipal() {
	}

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void stop() {
	}
	@Override
	public void init() {
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
			BorderPane root  = (BorderPane)FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
			Scene scene = new Scene(root,1280,745);
			scene.getStylesheets().add(getClass().getResource("/stylesheet/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.getIcons().add(new Image("https://img.freepik.com/vector-gratis/plantilla-logotipo-gimnasio-fitness-ilustracion-abstracta-vector-diseno-minimalista_53876-151333.jpg?w=740"));
			primaryStage.setTitle("Tienda en JavaFX");
			primaryStage.show();
	}
}
