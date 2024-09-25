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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class watchpropstatus_controller {
	
	@FXML
	TextField proposalfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
		}
	
	
	public void cancelbuttonpressed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
		root = loader.load();
		customer_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void watchbuttonpressed(ActionEvent event) throws IOException, ClassNotFoundException{
		String sts = "";
		String proposal_id = proposalfield.getText();
		int id_pr = Integer.parseInt(proposal_id);
		//send operation to server
		ArrayList<Object>data = new ArrayList<Object>();
		data.add(id_pr);
		request_operation req = new request_operation("watchproposalstatus",data);
		cli.sendData(req);
		
		//proposal_status
		
		ArrayList<proposal> prp = (ArrayList<proposal>) cli.receiveData();
		if(prp.get(0).getSellerSign() == 0) {
			sts = "In progress";
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
			root = loader.load();
			customer_controller controller = loader.getController();
			controller.setclient(cli);
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
			alert.showAndWait();
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
		}
		else if(prp.get(0).getSellerSign() != 0) {
			sts = "Completed";
			FXMLLoader loaderr = new FXMLLoader(getClass().getResource("/graphics/confirm_proposal.fxml"));
			root = loaderr.load();
			confirm_proposal_controller controllerr = loaderr.getController();
			controllerr.setclient(cli);
			controllerr.setdata(id_pr);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
		}
		
	}
}
