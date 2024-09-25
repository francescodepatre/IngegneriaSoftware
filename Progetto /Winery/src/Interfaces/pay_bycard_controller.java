package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.Wine;
import Actors.pre_buy;
import Actors.request_operation;
import Communication.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pay_bycard_controller {
	
	@FXML
	TextField namefield,surnamefield,cardnumberfield,monthfield,yearfield,cvvfield;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	int wineid;
	int quantity;
	int remaining;
	private ArrayList<pre_buy> previous_orders = new ArrayList<pre_buy>();
	
	private Client cli;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void setdata(final int q,final Wine win) {
		quantity = q;
		wineid = win.getwine_id();
		remaining = win.get_quantity();
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
	
	public void buybuttonpressed(ActionEvent e) throws IOException{
		if(quantity > remaining) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/advice.fxml"));
			root = loader.load();
			advice_controller controller = loader.getController();
			controller.setclient(cli);
			for(int i = 0; i < previous_orders.size(); i ++ ) {
				controller.set_previousorders(previous_orders.get(i));
			}
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
			}
		else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/graphics/customer_interface.fxml"));
			root = loader.load();
			customer_controller controller = loader.getController();
			controller.setclient(cli);
			
			for(int i = 0; i < previous_orders.size(); i ++) {
				ArrayList<Object> list = new ArrayList<Object>();
				list.add(previous_orders.get(i).getQuantity());
				list.add(previous_orders.get(i).getWine().getwine_id());
				list.add("Credit Card");
				list.set(0, previous_orders.get(i).getQuantity());
				list.set(1,previous_orders.get(i).getWine().getwine_id());
				list.set(2,"Credit Card");
				request_operation req = new request_operation("buywine",list);
				cli.sendData(req);
			}
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Winery");
			stage.show();
		}
	}
}
