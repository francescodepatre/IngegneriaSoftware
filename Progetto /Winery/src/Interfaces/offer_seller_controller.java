package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class offer_seller_controller {

	private Stage stage;
	private Scene scene;
	private Client cli;
	
	

	public void addbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/add_offer2.fxml"));
		Parent root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		add_offer_controller2 controller = loader.getController();
		controller.setclient(cli);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
		
	}
	public void deletebuttonpressed(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/remove_offer2.fxml"));
		Parent root = loader.load();
		remove_offer_controller2 controller = loader.getController();
		controller.setClient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
		
	}
	
	public void watchbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/offers_output2.fxml"));
		Parent root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		offer_output_controller2 controller = loader.getController();
		controller.setClient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		request_operation req = new request_operation("watchoffers",list);
		cli.sendData(req);
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
		
	}

	public void setClient(Client client) {
		// TODO Auto-generated method stub
		this.cli = client;
	}
	
	public void backbuttonpressed(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		Parent root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
		
	}
}
