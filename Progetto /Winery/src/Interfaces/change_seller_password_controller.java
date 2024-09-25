package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class change_seller_password_controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	
	@FXML
	TextField passwordfield;
	
	public void setclient(final Client c) {
		this.cli = c;
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void changebuttonpressed(ActionEvent event) throws IOException{
		String newpassword = passwordfield.getText();
		//send operation request to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(newpassword);
		request_operation req = new request_operation("changepassword_seller",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
