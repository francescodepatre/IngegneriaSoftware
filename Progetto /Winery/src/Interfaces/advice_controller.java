package Interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Actors.pre_buy;
import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class advice_controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	private int wine_id;
	private int quantity;
	private ArrayList<pre_buy> previous_orders = new ArrayList<pre_buy>();
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void setdata(final int i, final int q) {
		this.wine_id = i;
		this.quantity = q;
	}
	
	public void set_previousorders(final pre_buy pb) {
		this.previous_orders.add(pb);
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
	
	public void compilebuttonpressed(ActionEvent e) throws IOException{
		for(int i = 0; i < previous_orders.size(); i++) {
			Random rnd  = new Random();
			int prop_id = rnd.nextInt(0, 9999999);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Proposal ID");
			alert.setContentText("Proposal ID is: " + prop_id);
			alert.showAndWait();
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(previous_orders.get(i).getWine().getwine_id());
			list.add(previous_orders.get(i).getQuantity());
			list.add(prop_id);
			list.set(0,previous_orders.get(i).getWine().getwine_id());
			list.set(1, previous_orders.get(i).getQuantity());
			list.set(2, prop_id);
			request_operation req = new request_operation("proposal",list);
			cli.sendData(req);
		}
		
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
