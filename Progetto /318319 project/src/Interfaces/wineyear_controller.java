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

public class wineyear_controller {
	
	@FXML
	TextField wineyearfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
		root = loader.load();
		customer_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void searchbuttonpressed(ActionEvent event) throws IOException{
		String wineyear = wineyearfield.getText();
		int year = Integer.parseInt(wineyear);
		ArrayList<Object>list = new ArrayList<Object>();
		list.add(year);
		request_operation req = new request_operation("wineyear",list);
		cli.sendData(req);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_output_customer.fxml"));
		root = loader.load();
		wine_output_customer_controller controller = loader.getController();
		controller.setclient(cli);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
		
		
	}
	
}
