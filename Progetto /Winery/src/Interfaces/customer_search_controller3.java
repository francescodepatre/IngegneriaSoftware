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

public class customer_search_controller3 {

	@FXML
	TextField surnamefield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
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
	
	public void searchbuttonpressed(ActionEvent event) throws IOException{
		
		String surname = surnamefield.getText();
		
		//send values to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_output_admin.fxml"));
		root = loader.load();
		customer_output_admin_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(surname);
		request_operation req = new request_operation("searchcustomerbysurname",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
