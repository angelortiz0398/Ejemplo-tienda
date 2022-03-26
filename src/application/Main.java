package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public Main() {
		System.out.println("Constructor");
	}
	
	@Override
	public void init() {
		System.out.println("metodo init");

	}
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("TraductorAnchorPane.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Traductor con AnchorPane");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void stop() {
		System.out.println("stop");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
