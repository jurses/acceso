package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.Vista;

public class Controlador extends Application
{
	private vista.Vista vista;
	
	public Controlador()
	{
		vista = new vista.Vista();
	}
	
	public static void main(String []args)
	{
		launch(args);
	}

	public void start(Stage s)
	{
		Scene sc = new Scene(vista, 400, 200);
		s.setScene(sc);
		s.setTitle("Usuario y contraseña");
		s.setMinHeight(s.getMinHeight());
		s.setMinWidth(600);
		s.show();
	}
}
