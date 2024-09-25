package Interfaces;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import Operations.*;

public class Main_interface extends Application{
	
	
	public void start(final Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Interfaces.fxmlfiles/main_open.fxml"));
		Scene scene = new Scene(root,600,400);
		stage.setTitle("Welcome");
		stage.setScene(scene);
		stage.show();
	}
	
	public void main_login_button_is_pressed(final ActionEvent e) {
		new Login().Login_mechanism();
	}
	
	public void main_register_button_is_pressed(final ActionEvent e) {
		new Registration().Customer_reg();
	}
	
	public static void main(final String[] args) {
		Application.launch(Main_interface.class,args);
	}
}
