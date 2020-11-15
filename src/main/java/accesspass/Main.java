package accesspass;

import vista.Vista;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.Scene;

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
		
			
		CsvReader csvreader = new CsvReader("user-pass.csv");
		
		v.get_cancel().setOnAction(event -> {
			Platform.exit();
		});
		
		v.get_accept().setOnAction(event -> {
			String user;
			String password;
			
			user = v.get_user().getText();
			password = v.get_password().getText();
			System.out.println(csvreader.get_password(user));
			System.out.println(DigestUtils.md5Hex(password).toUpperCase());
			
			if(csvreader.get_password(user).equals(DigestUtils.md5Hex(password).toUpperCase()))
				v.get_access().show();
			else
				v.get_denied().show();
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