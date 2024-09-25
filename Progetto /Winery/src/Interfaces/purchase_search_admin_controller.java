package Interfaces;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class purchase_search_admin_controller {

	@FXML
	DatePicker startdate,enddate;
	
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
		
		Date start = Date.valueOf(startdate.getValue());
		Date end = Date.valueOf(enddate.getValue());
		String strt = start.toString();
		String nd = end.toString();
		//send values to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/purchase_admin_output.fxml"));
		root = loader.load();
		purchase_output_admin_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(strt);
		list.add(nd);
		list.set(0, strt);
		list.set(1, nd);
		request_operation req = new request_operation("searchpurchase",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
