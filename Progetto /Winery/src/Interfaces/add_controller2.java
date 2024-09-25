package Interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Actors.Wine;
import Actors.request_operation;
import Communication.Client;
import Operations.add_new_wine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class add_controller2 {
	private Stage stage;
	private Scene scene;
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	@FXML
	TextField namefield,yearfield,pricefield,quantityfield;
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
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
	
	public void addbuttonpressed(ActionEvent e) throws IOException {
		Random rnd = new Random();
		int wine_id = rnd.nextInt(999, 9999);
		String wine_name = namefield.getText();
		int wine_year =Integer.parseInt(yearfield.getText());
		float wine_price = (float) Double.parseDouble(pricefield.getText());
		int quantity = Integer.parseInt(quantityfield.getText());
		Wine wine = new Wine(wine_id,wine_name,wine_year,wine_price,quantity);
		new add_new_wine().wine_add(wine);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Wine Added");
		alert.setHeaderText("Wine ID");
		alert.setContentText("Wine ID: " + wine_id);
		alert.showAndWait();
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
