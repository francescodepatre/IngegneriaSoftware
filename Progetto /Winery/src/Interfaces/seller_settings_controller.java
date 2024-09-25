package Interfaces;

import java.io.IOException;

import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class seller_settings_controller {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	
	public void setclient(final Client c) {
		this.cli = c;
	}
	
	public void backbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void passwordbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_change_password.fxml"));
		root = loader.load();
		change_seller_password_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void usernamebuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_change_username.fxml"));
		root = loader.load();
		change_seller_username_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
