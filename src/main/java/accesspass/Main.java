package accesspass;

import vista.Vista;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application
{
	private Stage main_stage;
	
	
	@Override
	public void start(Stage s) throws IOException
	{
		Vista v = new Vista();
		main_stage = s;
		main_stage.setTitle("Usuario y contraseña");
		
		Alert access_denied;
		Alert access_granted;
		
		access_granted = new Alert(AlertType.CONFIRMATION);
		access_denied = new Alert(AlertType.ERROR);
		
		access_granted.setTitle("Iniciar Sesión");
		access_denied.setTitle("Iniciar Sesión");

		access_granted.setHeaderText("Para dentro");
		access_granted.setContentText("Para dentro");

		access_granted.setHeaderText("No entras");
		access_granted.setContentText("No entras");		
		CsvReader csvreader = new CsvReader("user-pass.csv");
		
		v.get_accept().setOnAction(event -> {
			String user;
			String password;
			
			
			user = v.get_user().getText();
			password = v.get_password().getText();
			System.out.println(csvreader.get_password(user));
			System.out.println(DigestUtils.md5Hex(password).toUpperCase());
			
			if(csvreader.get_password(user) == DigestUtils.md5Hex(password).toUpperCase())
			{
				access_granted.show();
			}
			else
			{
				access_denied.show();
			}
		});
		Scene sc = new Scene(v, 400, 200);
		main_stage.setScene(sc);
		main_stage.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
}