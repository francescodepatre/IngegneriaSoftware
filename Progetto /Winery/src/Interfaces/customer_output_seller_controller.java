package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.Customer;
import Actors.Wine;
import Actors.customer_output;
import Actors.wine_output;
import Communication.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class customer_output_seller_controller {

	@FXML
	private TableView<customer_output> tvData;
	@FXML
	private TableColumn<String, String> colid;
	@FXML
	private TableColumn<String, String> colname;
	@FXML
	private TableColumn<String, String> colsurname;
	@FXML
	private TableColumn<String, String> colcode;
	@FXML
	private TableColumn<String, String> colemail;
	@FXML
	private TableColumn<String, String> colphone;
	@FXML
	private TableColumn<String, String> coladdress;

	private ObservableList<customer_output> tvObservableList =
		      FXCollections.observableArrayList();
		  
		private Stage stage;
		private Scene scene;
		private Parent root;
		private Client cli;
		
		public void setclient(final Client c) {
			this.cli = c;
		}
		
		
		
		public void searchbuttonbuttonpressed(ActionEvent e) throws IOException, ClassNotFoundException{
			
			Object inputsocket = cli.receiveData();
			
			ArrayList<Customer> k = (ArrayList<Customer>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new customer_output(k.get(i).get_id(),k.get(i).get_name(),k.get(i).get_surname(),k.get(i).get_code(),k.get(i).get_email(),k.get(i).get_phone(),k.get(i).get_address()));
				tvData.refresh();
			}
			
		    colid.setCellValueFactory(new PropertyValueFactory<>("id"));
		    colname.setCellValueFactory(new PropertyValueFactory<>("name"));
		    colsurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		    colcode.setCellValueFactory(new PropertyValueFactory<>("code"));
		    colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
		    colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		    coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
		    tvData.setItems(tvObservableList);
			
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
