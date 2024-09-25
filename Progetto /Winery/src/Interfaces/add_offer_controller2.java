package Interfaces;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import Actors.Offer;
import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class add_offer_controller2 {
	
	@FXML
	DatePicker startdate,enddate;
	@FXML
	TextField winefield,discountfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void cancelbuttonpressed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void addbuttonpressed(ActionEvent event) throws IOException{

		Date start = Date.valueOf(startdate.getValue());
		Date end = Date.valueOf(enddate.getValue());
		int id_wine = Integer.parseInt(winefield.getText());
		int discount = Integer.parseInt(discountfield.getText());
		String strt = start.toString();
		String nd = end.toString();
		//send values to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		Random rnd = new Random();
		int id_off = rnd.nextInt(999999);
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Offer(id_off,id_wine,strt,nd,discount));
		request_operation req = new request_operation("addoffer",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
