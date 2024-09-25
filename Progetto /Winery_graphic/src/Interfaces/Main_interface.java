package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import Operations.*;

public class Main_interface extends Application{
	
	
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("main_open.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void main_login_button_is_pressed(final ActionEvent e) {
		new Login().Login_mechanism();
	}
	
	public void main_register_button_is_pressed(final ActionEvent e) {
		new Registration().Customer_reg();
	}
	
	public static void main(final String[] args) {
		launch(args);
	}
	
}
