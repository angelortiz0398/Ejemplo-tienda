/**
 * 
 */
package application;

import java.io.InputStream;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author 9
 *
 */
public class LoginHorizontal extends Application{

	/**
	 * 
	 */
	public LoginHorizontal() {
		// TODO Auto-generated constructor stub
	}

	public void init() {
		System.out.println("metodo init");

	}
	
	@Override
	public void start(Stage primaryStage) {
		VBox contenedorIzquierda = new VBox();
		Label titulo = new Label("Iniciar sesion");
		titulo.setFont(new Font(40));
		
		VBox contenedorLogin = new VBox();
		Label usuario = new Label("Usuario");
		usuario.setFont(new Font(20));
		Label password = new Label("Contraseña");
		password.setFont(new Font(20));
		TextField textoUsuario = new TextField();
		textoUsuario.setFont(new Font(18));
		textoUsuario.setPromptText("Ingrese su usuario");
		textoUsuario.setPrefWidth(341);
		textoUsuario.setPrefHeight(44);
		PasswordField textoPassword = new PasswordField();
		textoPassword.setFont(new Font(18));
		textoPassword.setPromptText("Ingrese su contraseña");
		textoPassword.setPrefWidth(341);
		textoPassword.setPrefHeight(44);
		Button boton = new Button("Entrar");
		boton.setFont(new Font(20));
		boton.setPrefWidth(370);
		boton.setPrefHeight(44);
		boton.setMaxWidth(Double.MAX_VALUE);
		boton.setCursor(Cursor.HAND);
		
		contenedorLogin.getChildren().addAll(usuario,textoUsuario,password,textoPassword,boton);
		contenedorLogin.setAlignment(Pos.TOP_LEFT);
		VBox.setMargin(usuario, new Insets(10,0,0,0));
		VBox.setMargin(password, new Insets(10,0,0,0));
		VBox.setMargin(boton, new Insets(20,0,0,0));
		contenedorIzquierda.getChildren().addAll(titulo,contenedorLogin);
		contenedorIzquierda.setPrefWidth(422);
		contenedorIzquierda.setAlignment(Pos.CENTER);
		VBox.setMargin(contenedorLogin, new Insets(0,30,0,30));
		
		VBox contenedorDerecha = new VBox();
		InputStream inputStream;
		inputStream = getClass().getResourceAsStream("/imagenes/a.png");
		Image imagen = new Image(inputStream);
		ImageView imageLogo = new ImageView(imagen);
		contenedorDerecha.getChildren().addAll(imageLogo);
		contenedorDerecha.setPrefWidth(422);
		contenedorDerecha.setAlignment(Pos.CENTER);
		contenedorDerecha.setBackground(new Background(new BackgroundFill(Color.web("#30373e"),CornerRadii.EMPTY,Insets.EMPTY)));
		
		HBox root = new HBox();
		root.getChildren().addAll(contenedorIzquierda,contenedorDerecha);
		HBox.setHgrow(contenedorIzquierda, Priority.ALWAYS);
		HBox.setHgrow(contenedorDerecha, Priority.ALWAYS);
		Scene escena = new Scene(root, 854,503);
		
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
