package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.proposal;
import Actors.proposal_output;
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

public class personal_controller2 {

	@FXML
	private TableView<proposal_output> tvData;
	@FXML
	private TableColumn<String, String> IDProposal;
	@FXML
	private TableColumn<String, String> IDWine;
	@FXML
	private TableColumn<String, String> IDCustomer;
	@FXML
	private TableColumn<String, String> Quantity;
	@FXML
	private TableColumn<String, String> Dateproposal;
	@FXML
	private TableColumn<String, String> Totalproposal;
	@FXML
	private TableColumn<String, String> Datecompilation;
	@FXML
	private TableColumn<String, String> Sellersign;
	@FXML
	private TableColumn<String, String> IDSeller;

	private ObservableList<proposal_output> tvObservableList =
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
			
			ArrayList<proposal> k = (ArrayList<proposal>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new proposal_output(k.get(i).getId(),k.get(i).getIdWine(),k.get(i).getIdCustomer(),k.get(i).getQuantity(),k.get(i).getDate(),k.get(i).getTotal(),k.get(i).getDateCompilation(),k.get(i).getSellerSign(),k.get(i).getSellerId()));
				tvData.refresh();
			}
			
			IDProposal.setCellValueFactory(new PropertyValueFactory<>("idproposal"));
			IDWine.setCellValueFactory(new PropertyValueFactory<>("idwine"));
			IDCustomer.setCellValueFactory(new PropertyValueFactory<>("idcustomer"));
			Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			Dateproposal.setCellValueFactory(new PropertyValueFactory<>("dateproposal"));
			Totalproposal.setCellValueFactory(new PropertyValueFactory<>("totalproposal"));
			Datecompilation.setCellValueFactory(new PropertyValueFactory<>("datecompilation"));
			Sellersign.setCellValueFactory(new PropertyValueFactory<>("sellersign"));
			IDSeller.setCellValueFactory(new PropertyValueFactory<>("idseller"));
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
