package vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Vista extends VBox{
	private Label l_user;
	private Label l_password;
	private TextField tf_user;
	private PasswordField pf_pass;
	private Button bt_accept;
	private Button bt_dismiss;
	
	public Vista()
	{
		super();
		
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
	
	public TextField get_user()
	{
		return tf_user;
	}
	
	public PasswordField get_password()
	{
		return pf_pass;
	}
	
	public Button get_accept()
	{
		return bt_accept;
	}
}
