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

public class change_admin_username_controller {

	@FXML
	TextField usernamefield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void changebuttonpressed(ActionEvent event) throws IOException{
		String newpassword = usernamefield.getText();
		//send operation request to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(newpassword);
		request_operation req = new request_operation("changeusername_admin",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
