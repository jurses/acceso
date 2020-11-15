package vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Vista extends VBox{
	private Label l_user;
	private Label l_password;
	private TextField tf_user;
	private PasswordField pf_pass;
	private Button bt_accept;
	private Alert access_denied;
	private Alert access_granted;
	private Button bt_dismiss;
	
	public Vista()
	{
		super();
		
		
		
		access_granted = new Alert(AlertType.CONFIRMATION);
		access_denied = new Alert(AlertType.ERROR);
		
		access_granted.setTitle("Iniciar Sesión");
		access_denied.setTitle("Iniciar Sesión");

		access_granted.setHeaderText("Para dentro");
		access_granted.setContentText("Para dentro");

		access_denied.setHeaderText("No entras");
		access_denied.setContentText("No entras");	
		
		l_user = new Label("Usuario:");
		l_password = new Label("Password:");
		tf_user = new TextField();
		pf_pass = new PasswordField();
		bt_accept = new Button("Aceptar");
		bt_dismiss = new Button("Cancelar");
		
		GridPane gp_info = new GridPane();
		HBox hb_buttons = new HBox();
		
		gp_info.add(l_user, 0, 0);
		gp_info.add(l_password, 0, 1);
		gp_info.add(tf_user, 1, 0);
		gp_info.add(pf_pass, 1, 1);
		
		hb_buttons.getChildren().add(bt_accept);
		hb_buttons.getChildren().add(bt_dismiss);
		
		this.getChildren().add(gp_info);
		this.getChildren().add(hb_buttons);
	}
	
	public Alert get_access()
	{
		return access_granted;
	}
	public Alert get_denied()
	{
		return access_denied;
	}
	
	public TextField get_user()
	{
		return tf_user;
	}
	
	public PasswordField get_password()
	{
		return pf_pass;
	}
	
	public Button get_cancel()
	{
		return bt_dismiss;
	}
	
	public Button get_accept()
	{
		return bt_accept;
	}
}
