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

public class proposal_search_controller3 {

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/proposal_output3.fxml"));
		root = loader.load();
		proposal_output_controller3 controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(start);
		list.add(end);
		list.set(0, strt);
		list.set(1, nd);
		request_operation req = new request_operation("searchproposal",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
