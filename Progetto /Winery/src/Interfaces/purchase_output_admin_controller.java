package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.purchase;
import Actors.purchase_output;
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

public class purchase_output_admin_controller {

	@FXML
	private TableView<purchase_output> tvData;
	@FXML
	private TableColumn<String, String> colid;
	@FXML
	private TableColumn<String, String> colwine;
	@FXML
	private TableColumn<String, String> colquantity;
	@FXML
	private TableColumn<String, String> colprice;
	@FXML
	private TableColumn<String, String> coldate;
	@FXML
	private TableColumn<String, String> colcustomer;
	@FXML
	private TableColumn<String, String> colmethod;

	private ObservableList<purchase_output> tvObservableList =
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
			
			ArrayList<purchase> k = (ArrayList<purchase>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new purchase_output(k.get(i).getid(),k.get(i).getwine(),k.get(i).getquantity(),k.get(i).gettotal(),k.get(i).getdate(),k.get(i).getcustomer(),k.get(i).getmethod()));
				tvData.refresh();
			}
			
		    colid.setCellValueFactory(new PropertyValueFactory<>("idorder"));
			colwine.setCellValueFactory(new PropertyValueFactory<>("idwine"));
			colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			colprice.setCellValueFactory(new PropertyValueFactory<>("totalprice"));
			coldate.setCellValueFactory(new PropertyValueFactory<>("dateorder"));
			colcustomer.setCellValueFactory(new PropertyValueFactory<>("idcustomer"));
			colmethod.setCellValueFactory(new PropertyValueFactory<>("method"));
		    tvData.setItems(tvObservableList);
			
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
