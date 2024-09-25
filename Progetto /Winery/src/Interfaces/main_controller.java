package Interfaces;

import java.io.IOException;

import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main_controller {
	
	private Stage stage;
	private Scene scene;
	private Client cli;
	
	

	public void main_login_button_is_pressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/login_page.fxml"));
		Parent root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Login_controller controller = loader.getController();
		controller.setClient(cli);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
		
	}
	public void main_register_button_is_pressed(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/registration.fxml"));
		Parent root = loader.load();
		Registration_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Customer Registration");
		stage.show();
		
		
	}

	public void setClient(Client client) {
		// TODO Auto-generated method stub
		this.cli = client;
	}

}
