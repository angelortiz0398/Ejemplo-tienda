package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GridPaneCalculadora extends Application{

	public GridPaneCalculadora() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		System.out.println("metodo init");

	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void stop() {
		System.out.println("stop");
	}
	
	public void addPrefDimensionButton(Button boton,int width, int height) {
		boton.setPrefWidth(width);
		boton.setMaxHeight(height);
	}
	public void addMaxfDimensionButton(Button boton) {
		boton.setMaxWidth(Double.MAX_VALUE);
		boton.setMaxHeight(Double.MAX_VALUE);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button boton1 = new Button("1");
		Button boton2 = new Button("2");
		Button boton3 = new Button("3");
		Button boton4 = new Button("4");
		Button boton5 = new Button("5");
		Button boton6 = new Button("6");
		Button boton7 = new Button("7");
		Button boton8 = new Button("8");
		Button boton9 = new Button("9");
		Button boton0 = new Button("0");
		
		Button suma = new Button("+");
		Button resta = new Button("-");
		Button multiplicacion = new Button("*");
		Button division = new Button("/");
		Button igual = new Button("=");
		Button borrar = new Button("C");
		
		TextField textoOperaciones = new TextField();
		GridPane gPane = new GridPane();
		// Fila 0
		GridPane.setConstraints(textoOperaciones, 0, 0, 4, 1);
		// Fila 1
		GridPane.setConstraints(boton7, 0, 1);
		GridPane.setConstraints(boton8, 1, 1);
		GridPane.setConstraints(boton9, 2, 1);
		GridPane.setConstraints(suma, 3, 1);
		// Fila 2
		GridPane.setConstraints(boton4, 0, 2);
		GridPane.setConstraints(boton5, 1, 2);
		GridPane.setConstraints(boton6, 2, 2);
		GridPane.setConstraints(resta, 3, 2);
		// Fila 3
		GridPane.setConstraints(boton1, 0, 3);
		GridPane.setConstraints(boton2, 1, 3);
		GridPane.setConstraints(boton3, 2, 3);
		GridPane.setConstraints(multiplicacion, 3, 3);
		// Fila 4
		GridPane.setConstraints(borrar, 0, 4);
		GridPane.setConstraints(boton0, 1, 4);
		GridPane.setConstraints(igual, 2, 4);
		GridPane.setConstraints(division, 3, 4);
		
		textoOperaciones.setMaxWidth(Double.MAX_VALUE);
		textoOperaciones.setMaxHeight(Double.MAX_VALUE);
		textoOperaciones.setPrefHeight(35);
		
		addPrefDimensionButton(boton0, 55, 35);
		addPrefDimensionButton(boton1, 55, 35);
		addPrefDimensionButton(boton2, 55, 35);
		addPrefDimensionButton(boton3, 55, 35);
		addPrefDimensionButton(boton4, 55, 35);
		addPrefDimensionButton(boton5, 55, 35);
		addPrefDimensionButton(boton6, 55, 35);
		addPrefDimensionButton(boton7, 55, 35);
		addPrefDimensionButton(boton8, 55, 35);
		addPrefDimensionButton(boton9, 55, 35);
		addPrefDimensionButton(suma, 55, 35);
		addPrefDimensionButton(resta, 55, 35);
		addPrefDimensionButton(multiplicacion, 55, 35);
		addPrefDimensionButton(division, 55, 35);
		addPrefDimensionButton(borrar, 55, 35);
		addPrefDimensionButton(igual, 55, 35);
		
		GridPane.setVgrow(textoOperaciones, Priority.ALWAYS);
		GridPane.setVgrow(boton7, Priority.ALWAYS);
		GridPane.setVgrow(boton4, Priority.ALWAYS);
		GridPane.setVgrow(boton1, Priority.ALWAYS);
		GridPane.setVgrow(borrar, Priority.ALWAYS);
		
		GridPane.setHgrow(boton7, Priority.ALWAYS);
		GridPane.setHgrow(boton8, Priority.ALWAYS);
		GridPane.setHgrow(boton9, Priority.ALWAYS);
		GridPane.setHgrow(suma, Priority.ALWAYS);
		
		addMaxfDimensionButton(boton0);
		addMaxfDimensionButton(boton1);
		addMaxfDimensionButton(boton2);
		addMaxfDimensionButton(boton3);
		addMaxfDimensionButton(boton4);
		addMaxfDimensionButton(boton5);
		addMaxfDimensionButton(boton6);
		addMaxfDimensionButton(boton7);
		addMaxfDimensionButton(boton8);
		addMaxfDimensionButton(boton9);
		addMaxfDimensionButton(suma);
		addMaxfDimensionButton(resta);
		addMaxfDimensionButton(multiplicacion);
		addMaxfDimensionButton(division);
		addMaxfDimensionButton(borrar);
		addMaxfDimensionButton(igual);
		
		gPane.setAlignment(Pos.CENTER);
		gPane.setHgap(5);
		gPane.setVgap(5);
		gPane.getChildren().addAll(boton0,boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,suma,resta,multiplicacion,division,borrar,igual,textoOperaciones);
		
		StackPane.setMargin(gPane, new Insets(10));
		StackPane root = new StackPane(gPane);
		Scene escena = new Scene(root, 300,300);
		
		primaryStage.setTitle("Calculadora con Grid Pane");
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}

}
