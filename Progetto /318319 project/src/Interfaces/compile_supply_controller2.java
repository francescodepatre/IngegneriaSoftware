package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import Operations.Compile_supply;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class compile_supply_controller2 {
	
	@FXML
	TextField supplierfield,winefield,quantityfield;
	
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
	
	public void compilebuttonpressed(ActionEvent event) throws IOException{
		
		String supplier_tmp = supplierfield.getText();
		String wine_tmp = winefield.getText();
		String quantity_tmp = quantityfield.getText();
		
		int supplier = Integer.parseInt(supplier_tmp);
		int wine = Integer.parseInt(wine_tmp);
		int quantity = Integer.parseInt(quantity_tmp);
		
		//send values to server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		
		new Compile_supply().compile_supply(wine, supplier, quantity);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
