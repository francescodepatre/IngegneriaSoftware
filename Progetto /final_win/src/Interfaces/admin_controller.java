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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import Operations.Prepare_report;

public class admin_controller {

	@FXML

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void winenamebuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_name3.fxml"));
		root = loader.load();
		winename_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search Wine By Name");
		stage.show();
	}
	
	public void wineyearbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_year3.fxml"));
		root = loader.load();
		wineyear_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search Wine By Year");
		stage.show();
	}
	
	public void winegeneralbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_search3.fxml"));
		root = loader.load();
		winesearch_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search Wine By Year And Name");
		stage.show();
	}
	
	public void proposalsearchbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/proposal_search3.fxml"));
		root = loader.load();
		proposal_search_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search Proposal");
		stage.show();
	}
	
	public void customersearchbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_search3.fxml"));
		root = loader.load();
		customer_search_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search Customers by Surname");
		stage.show();
	}
	
	public void compilesupplybuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/compile_supply3.fxml"));
		root = loader.load();
		compile_supply_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Compile Supply");
		stage.show();
	}
	
	public void examineproposalbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/examine_proposal_admin.fxml"));
		root = loader.load();
		examine_proposal_admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Examine Proposal");
		stage.show();
	}
	
	public void compileproposalbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/compile_proposal3.fxml"));
		root = loader.load();
		compile_proposal_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Compile Proposal");
		stage.show();
		}
	
	public void searchsupplybuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/supplysearch_admin.fxml"));
		root = loader.load();
		supplysearch_admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search supply");
		stage.show();
	}
	
	public void searchpurchasebuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/purchasesearch_admin.fxml"));
		root = loader.load();
		purchase_search_admin_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Search purchase");
		stage.show();
	}
	
	public void exitbuttonpressed(ActionEvent e) throws IOException{
		cli.close();
		System.exit(0);
		
	}
	
	public void changepasswordbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admin_settings.fxml"));
		root = loader.load();
		admin_settings_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Change Password");
		stage.show();
	}
	
	public void addsellerbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/registration_seller.fxml"));
		root = loader.load();
		registration_seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Add Seller Account");
		stage.show();	
		}
	
	public void resetsellerbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/reset_seller.fxml"));
		root = loader.load();
		reset_seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Reset Seller Account");
		stage.show();
		}
	
	public void deletesellerbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/deleteseller.fxml"));
		root = loader.load();
		delete_seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Delete Seller Account");
		stage.show();
	}
	
	public void compilereportbuttonpressed(ActionEvent e) throws IOException{
		AlertType type = AlertType.INFORMATION;
		Alert alert = new Alert(type);
		alert.setTitle("Information");
		alert.setHeaderText("Report status");
		alert.setContentText("Monthly report avaible as 'report.txt'.");
		
		new Prepare_report().produce_montly_report();
	}
	
	public void personalbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/personal_proposal3.fxml"));
		root = loader.load();
		personal_controller3 controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		request_operation req = new request_operation("personalproposal",list);
		cli.sendData(req);
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void newwinebuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/add_wine3.fxml"));
		root = loader.load();
		add_controller3 controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void offersbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/offer_mgmt_admin.fxml"));
		root = loader.load();
		offer_admin_controller controller = loader.getController();
		controller.setClient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
