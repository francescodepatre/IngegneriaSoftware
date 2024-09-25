package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.Offer;
import Actors.offer_output;
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

public class offer_output_controller2 {

	@FXML
	private TableView<offer_output> tvData;
	@FXML
	private TableColumn<String, String> IDoffer;
	@FXML
	private TableColumn<String, String> IDWine;
	@FXML
	private TableColumn<String, String> Datestart;
	@FXML
	private TableColumn<String, String> Dateend;
	@FXML
	private TableColumn<String, String> Discount;

	private ObservableList<offer_output> tvObservableList =
		      FXCollections.observableArrayList();
		  
		private Stage stage;
		private Scene scene;
		private Parent root;
		private Client cli;
		
		public void setclient(final Client c) {
			this.cli = c;
		}
		
		
		
		public void searchbuttonpressed(ActionEvent e) throws IOException, ClassNotFoundException{
			
			Object inputsocket = cli.receiveData();
			
			ArrayList<Offer> k = (ArrayList<Offer>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new offer_output(k.get(i).getid(),k.get(i).getwine(),k.get(i).getstartingdate(),k.get(i).getendingdate(),k.get(i).getdiscount()));
				tvData.refresh();
			}
			IDoffer.setCellValueFactory(new PropertyValueFactory<>("idoffer"));
			IDWine.setCellValueFactory(new PropertyValueFactory<>("wine"));
			Datestart.setCellValueFactory(new PropertyValueFactory<>("start"));
			Dateend.setCellValueFactory(new PropertyValueFactory<>("end"));
			Discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
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
		
		public void setClient(Client client) {
			// TODO Auto-generated method stub
			this.cli = client;
		}
}
