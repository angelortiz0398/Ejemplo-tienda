package application;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginVertical extends Application {

	public LoginVertical() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		System.out.println("metodo init");

	}
	
	@Override
	public void start(Stage primaryStage) {
		Label titulo = new Label("Iniciar sesion");
		titulo.setFont(new Font(30));
		Label usuario = new Label("Usuario");
		usuario.setFont(new Font(20));
		Label password = new Label("Contraseña");
		password.setFont(new Font(20));
		
		TextField textoUsuario = new TextField();
		textoUsuario.setMaxWidth(150);
		PasswordField textoPassword = new PasswordField();
		textoPassword.setMaxWidth(150);
		Button boton = new Button("Entrar");
		boton.setMaxWidth(150);
		boton.setCursor(Cursor.HAND);
		VBox root = new VBox();
		root.getChildren().addAll(titulo,usuario,textoUsuario,password,textoPassword,boton);
		root.setAlignment(Pos.CENTER);
		VBox.setMargin(usuario, new Insets(10,0,0,0));
		VBox.setMargin(password, new Insets(10,0,0,0));
		VBox.setMargin(boton, new Insets(10,0,0,0));
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
