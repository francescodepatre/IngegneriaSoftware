package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.Offer;
import Actors.request_operation;
import Communication.Client;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Operations.Login;
import Operations.type_account;

public class Login_controller{
	
	@FXML
	TextField usernamefield,passwordfield;
	
	private Client cli;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void setClient(final Client c) {
		this.cli = c;
	}
	
	public void login_confirmed(ActionEvent event) throws IOException, ClassNotFoundException{
		
		String usrnm = usernamefield.getText();
		String psswd = passwordfield.getText();
		
		int user_id = new Login().Login_mechanism(usrnm, psswd);
		//send data to client
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(user_id);
		request_operation req = new request_operation("loginUID",list);
		cli.sendData(req);
		
		
		if(user_id == 0) {
			AlertType type = AlertType.ERROR;
			Alert alert = new Alert(type);
			alert.setTitle("Login Error!");
			alert.setHeaderText("Login Failed!");
			alert.setContentText("Please check username or password");
			alert.showAndWait();
		}
		else {
			String typeaccount = new type_account().get_type(user_id);
			
			switch(typeaccount){
				case "Customer":
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
					root = loader.load();
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					customer_controller controller = loader.getController();
					controller.setclient(cli);
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Welcome to winery!");
					stage.show();
					
					ArrayList<Object> lista = new ArrayList<Object>();
					request_operation reqesta = new request_operation("lastoffers",list);
					cli.sendData(reqesta);
					
					Offer off = (Offer) cli.receiveData();
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Welcome!");
					alert.setHeaderText("New Offers");
					alert.setContentText(off.toString());
					alert.show();
					break;
					
				case "Seller":
					loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
					root = loader.load();
					seller_controller controllers = loader.getController();
					controllers.setclient(cli);
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Welcome to winery!");
					stage.show();
					break;
				case "Admin":
					loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
					root = loader.load();
					admin_controller controllera = loader.getController();
					controllera.setclient(cli);
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Welcome to winery!");
					stage.show();
					break;
				case "Supplier":
					loader = new FXMLLoader(getClass().getResource("/graphics/supplierinterface.fxml"));
					root = loader.load();
					supplier_controller controllersupp = loader.getController();
					controllersupp.setclient(cli);
					ArrayList<Object> listd = new ArrayList<Object>();
					request_operation reqes = new request_operation("supplyint",listd);
					cli.sendData(reqes);
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Welcome to winery!");
					stage.show();
					break;
			}
		}
	}
	
	public void login_cancelled(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/main_open.fxml"));
		root = loader.load();
		main_controller controller = loader.getController();
		controller.setClient(cli);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Welcome to Winery!");
		stage.show();
	}
}
