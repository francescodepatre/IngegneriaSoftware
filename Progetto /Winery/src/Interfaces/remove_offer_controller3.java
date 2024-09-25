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

public class remove_offer_controller3 {
	@FXML
	TextField idfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Client cli;
	
	public void setClient(Client client) {
		// TODO Auto-generated method stub
		this.cli = client;
	}
	
	public void cancelbuttonpressed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void deletebuttonpressed(ActionEvent event) throws IOException{

		int id_offer = Integer.parseInt(idfield.getText());
		//send values to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(id_offer);
		list.set(0, id_offer);
		request_operation req = new request_operation("rmoffer",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
