package Interfaces;

import java.io.IOException;

import Communication.Client;
import Operations.Seller_registration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registration_seller_controller {
	private Stage stage;
	private Scene scene;
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	
	@FXML
	TextField namefield,surnamefield,codefield,emailfield, phonefield,addressfield,usernamefield,passwordfield;
	
	public void registerbuttonpressed(ActionEvent event) throws IOException {
		
		String name = namefield.getText();
		String surname = surnamefield.getText();
		String fiscal_code = codefield.getText();
		String email = emailfield.getText();
		String phone = phonefield.getText();
		String address = addressfield.getText();
		String username = usernamefield.getText();
		String password = passwordfield.getText();
		
		new Seller_registration().Seller_reg(name, surname, fiscal_code, email, phone, address, username, password);
					
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		Parent root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		Parent root = loader.load();
		admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
