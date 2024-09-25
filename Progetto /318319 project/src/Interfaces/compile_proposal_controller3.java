package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import Operations.Remove_proposal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class compile_proposal_controller3 {
	
	@FXML
		
		TextField idproposalfield;
		
		private Stage stage;
		private Scene scene;
		private Parent root;
		
	private Client cli;
		
		public void setclient(Client c) {
			this.cli = c;
		}
		
		public void compilebuttonpressed(ActionEvent e) throws IOException{
			String id = idproposalfield.getText();
			int idproposal = Integer.parseInt(id);
			//send value to the server
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
			root = loader.load();
			admin_controller controller = loader.getController();
			controller.setclient(cli);
			
			new  Remove_proposal().update(idproposal, 1);
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
		}
		
		public void cancelbuttonpressed(ActionEvent e) throws IOException{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
			root = loader.load();
			admin_controller controller = loader.getController();
			controller.setclient(cli);			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
		}
	}


