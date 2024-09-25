package Interfaces;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import java.io.IOException;

import Communication.Client;
import Operations.Registration;

public class Registration_controller {
	
	private Stage stage;
	private Scene scene;
	
	@FXML
	TextField name_registration,surname_registration,fiscal_code_registration,email_registration, phone_registration,address_registration,username_registration,password_registration;
	
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void confirmed_registration(ActionEvent event) {
		try {
			String name = name_registration.getText();
			String surname = surname_registration.getText();
			String fiscal_code = fiscal_code_registration.getText();
			String email = email_registration.getText();
			String phone = phone_registration.getText();
			String address = address_registration.getText();
			String username = username_registration.getText();
			String password = password_registration.getText();
			
			new Registration().Customer_reg(name, surname, fiscal_code, email, phone, address, username, password);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/main_open.fxml"));
			Parent root = loader.load();
			main_controller controller = loader.getController();
			controller.setClient(cli);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Welcome to winery!");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void cancel_registration(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/main_open.fxml"));
		Parent root = loader.load();
		main_controller controller = loader.getController();
		controller.setClient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Welcome to winery!");
		stage.show();
	}
	}
