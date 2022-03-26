package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LGridPane extends Application {

	public LGridPane() {
		// TODO Auto-generated constructor stub
	}

@Override
public void init() {
	System.out.println("metodo init");

}
@Override
public void start(Stage primaryStage) {
	Button boton1 = new Button("Boton 1");
	Button boton2 = new Button("Boton 2");
	Button boton3 = new Button("Boton 3");
	Button boton4 = new Button("Boton 4");
	Button boton5 = new Button("Boton 5");
	Button boton6 = new Button("Boton 6");
	
	GridPane root = new GridPane();
	GridPane.setColumnIndex(boton1, 0);
	GridPane.setRowIndex(boton1, 0);
	GridPane.setRowSpan(boton1, 2);
	boton1.setMaxHeight(Double.MAX_VALUE);
	GridPane.setConstraints(boton2, 1, 0,2,1);
	boton2.setMaxWidth(Double.MAX_VALUE);
	GridPane.setConstraints(boton3, 2, 0);
	GridPane.setConstraints(boton4, 0, 1);
	GridPane.setConstraints(boton5, 1, 1);
	GridPane.setConstraints(boton6, 2, 1);
	root.setHgap(10);
	root.setVgap(10);
	root.getChildren().addAll(boton1,boton2,boton5,boton6);
	Scene escena = new Scene(root, 300,300);
	
	primaryStage.setTitle("Login");
	primaryStage.setScene(escena);
	primaryStage.show();
	
}
@Override
public void stop() {
	System.out.println("stop");
}
public static void main(String[] args) {
	launch(args);
}
}
