package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Actors.pre_buy;
import Communication.Client;
import Operations.Wine_searchID;
import Operations.quantity_choice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class buywine_controller implements Initializable{
	
	@FXML
	private ChoiceBox<String> type_pack;
	@FXML
	private TextField idfield;
	@FXML
	private TextField quantityfield;
	
	private String[] packs = {"Single pack","Double pack","Pack of 3","Pack of 4","Pack of 5","6-case","12-case"};
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	private ArrayList<pre_buy> last_orders = new ArrayList<pre_buy>();
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void set_ords(final pre_buy pb) {
		this.last_orders.add(pb);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		type_pack.getItems().addAll(packs);
	}
	
	public void creditcardbuttonpressed(ActionEvent e) throws IOException{
		int id = Integer.parseInt(idfield.getText());
		int type = new quantity_choice().get_choice(type_pack.getValue());
		int quantity = (Integer.parseInt(quantityfield.getText()) * type);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/pay_bycard.fxml"));
		root = loader.load();
		pay_bycard_controller controller = loader.getController();
		controller.setclient(cli);
		controller.set_previousorders(new pre_buy(new Wine_searchID().wine_id(id),quantity));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Pay By Credit Card");
		stage.show();
	}
	
	public void bankbuttonpressed(ActionEvent e) throws IOException{
		int id = Integer.parseInt(idfield.getText());
		int type = new quantity_choice().get_choice(type_pack.getValue());
		int quantity = (Integer.parseInt(quantityfield.getText()) * type);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/pay_bybank.fxml"));
		root = loader.load();
		pay_bybank_controller controller = loader.getController();
		controller.setclient(cli);
		controller.set_previousorders(new pre_buy(new Wine_searchID().wine_id(id),quantity));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Pay By Bank");
		stage.show();
	}
	
	public void multipleorderbuttonpressed(ActionEvent e) throws IOException{
		int id = Integer.parseInt(idfield.getText());
		int type = new quantity_choice().get_choice(type_pack.getValue());
		int quantity = (Integer.parseInt(quantityfield.getText()) * type);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/buy_wine.fxml"));
		root = loader.load();
		buywine_controller controller = loader.getController();
		controller.setclient(cli);
		controller.set_ords(new pre_buy(new Wine_searchID().wine_id(id), quantity));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
		root = loader.load();
		customer_controller controller = loader.getController();
		controller.setclient(cli);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Winery");
		stage.show();
	}
}
