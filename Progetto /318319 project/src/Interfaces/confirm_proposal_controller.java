package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.request_operation;
import Communication.Client;
import Operations.Remove_proposal;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class confirm_proposal_controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Client cli;
	int id_prp;
	
	public void setclient(Client c) {
		this.cli = c;
	}
	
	public void setdata(int id) {
		this.id_prp = id;
	}
	
	public void cancelbuttonpressed(ActionEvent e) throws IOException{
		/*
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(id_prp);
		list.set(0, id_prp);
		request_operation req = new request_operation("removeproposal",list);
		cli.sendData(req);
		*/
		new Remove_proposal().remove(id_prp);
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
	
	public void proceedbuttonpressed(ActionEvent e) throws IOException{
		/*
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(id_prp);
		list.set(0, id_prp);
		request_operation req = new request_operation("confprop",list);
		cli.sendData(req);
		*/
		new Remove_proposal().add_to_purchase(id_prp, 4);
		
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
