package accesspass;

import vista.Vista;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
	private Stage main_stage;
	private Alert access_denied;
	private Alert access_granted;
	
	@Override
	public void start(Stage s) throws IOException
	{
		Vista v = new Vista();
		main_stage = s;
		main_stage.setTitle("Usuario y contraseña");
		Scene sc = new Scene(v, 400, 200);
		main_stage.setScene(sc);
		
		access_granted = new Alert(AlertType.CONFIRMATION);
		access_denied = new Alert(AlertType.ERROR);
		
		access_granted.setTitle("Iniciar Sesión");
		access_denied.setTitle("Iniciar Sesión");

		access_granted.setHeaderText("Para dentro");
		access_granted.setContentText("Para dentro");

		access_granted.setHeaderText("No entras");
		access_granted.setContentText("No entras");		
		
		v.get_accept().setOnAction(event -> {
			String user;
			String password;
			CsvReader csvreader = new CsvReader("user-pass.csv");
			
			user = v.get_user().getText();
			password = v.get_password().getText();
			
			if(csvreader.get_password(user) == DigestUtils.md5Hex(password).toUpperCase())
				access_granted.show();
			else
				access_denied.show();
		});
		
		main_stage.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
}