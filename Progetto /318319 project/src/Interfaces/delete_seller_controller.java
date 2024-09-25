package Interfaces;

import java.io.IOException;

import Communication.Client;
import Operations.Delete_seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class delete_seller_controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	TextField sellerfield;
	
private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void removebuttonpressed(ActionEvent event) throws IOException {
		
		String id = sellerfield.getText();
		int sellerid = Integer.parseInt(id);
		
		new Delete_seller().Seller_delete(sellerid);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/admininterface.fxml"));
		root = loader.load();
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
