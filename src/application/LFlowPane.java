package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LFlowPane extends Application{

	public LFlowPane() {
		
	}
	public void init() {
		System.out.println("metodo init");

	}
	@Override
	public void stop() {
		System.out.println("stop");
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button boton[] = new Button[15];

		FlowPane root = new FlowPane();
		root.setOrientation(Orientation.VERTICAL);
		root.setHgap(10);
		root.setVgap(10);
		for (int i = 0; i < boton.length; i++) {
			boton[i] = new Button("Boton " +(i + 1));
			root.getChildren().add(boton[i]);
		}
		
		Scene escena = new Scene(root, 300,250);
		primaryStage.setTitle("LFlowPane");
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}
}
