package Interfaces;

import java.io.IOException;

import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class customer_controller {

		@FXML
		private Client cli;
		private Stage stage;
		private Scene scene;
		private Parent root;
		
		public void setclient(Client c) {
			this.cli = c;
		}
		
		public void winesearchname(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_name.fxml"));
			root = loader.load();
			winename_controller controller = loader.getController();
			controller.setclient(cli);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Search Wine By Name");
			stage.show();
		}
		
		public void winesearchyear(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_year.fxml"));
			root = loader.load();
			wineyear_controller controller = loader.getController();
			controller.setclient(cli);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Search Wine By Year");
			stage.show();
		}
		
		public void winegeneralsearch(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/wine_search.fxml"));
			root = loader.load();
			winesearch_controller controller = loader.getController();
			controller.setclient(cli);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Search Wine By Year And Name");
			stage.show();
		}
		
		public void buywine(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/buy_wine.fxml"));
			root = loader.load();
			buywine_controller controller = loader.getController();
			controller.setclient(cli);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Buy Wine");
			stage.show();		}
		
		public void watchproposal(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/watchpropstatus.fxml"));
			root = loader.load();
			watchpropstatus_controller controller = loader.getController();
			controller.setclient(cli);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Watch proposal status");
			stage.show();
		}
		
		public void quitapplication(ActionEvent e) throws IOException {
			cli.close();
			System.exit(0);
		}
	
}
