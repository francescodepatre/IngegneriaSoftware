package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.proposal;
import Actors.request_operation;
import Communication.Client;
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

public class examine_proposal_controller {
	
	@FXML
	
	TextField idfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void searchbuttonpressed(ActionEvent e) throws IOException, ClassNotFoundException{
		String id = idfield.getText();
		int idproposal = Integer.parseInt(id);
		//send value to the server
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(idproposal);
		request_operation req = new request_operation("examineproposal",list);
		cli.sendData(req);
		
		String sts = "";
		
		ArrayList<proposal> prp = (ArrayList<proposal>) cli.receiveData();
		if(prp.get(0).getSellerSign() == 0) {
			sts = "In progress";
		}
		else if(prp.get(0).getSellerSign() != 0) {
			sts = "Completed";
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Proposal status");
		alert.setHeaderText("Proposal Details");
		alert.setContentText(
			"Proposal id: " + prp.get(0).getId() + "\n"+
			"Customer id: " + prp.get(0).getIdCustomer() + "\n"+
			"Wine id: " + prp.get(0).getIdWine() + "\n"+
			"Quantity: " + prp.get(0).getQuantity() + "\n"+
			"Date Proposal: " + prp.get(0).getDate() + "\n"+
			"Total: " + prp.get(0).getTotal() + "\n"+
			"Date Compilation: " + prp.get(0).getDateCompilation() + "\n"+
			"Status: " + sts + "\n"+
			"Seller id: " + prp.get(0).getSellerId() + "\n"
		);
		alert.show();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/seller_interface.fxml"));
		root = loader.load();
		seller_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
