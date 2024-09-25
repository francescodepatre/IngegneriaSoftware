package Interfaces;

import java.io.IOException;
import java.util.ArrayList;

import Actors.supply;
import Actors.supply_output;
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

public class supply_output_controller3 {

	@FXML
	private TableView<supply_output> tvData;
	@FXML
	private TableColumn<String, String> colid;
	@FXML
	private TableColumn<String, String> colwine;
	@FXML
	private TableColumn<String, String> colcustomer;
	@FXML
	private TableColumn<String, String> colquantity;
	@FXML
	private TableColumn<String, String> colprice;
	@FXML
	private TableColumn<String, String> coldate;

	private ObservableList<supply_output> tvObservableList =
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
			
			ArrayList<supply> k = (ArrayList<supply>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new supply_output(k.get(i).getid(),k.get(i).getwine(),k.get(i).getsupplier(),k.get(i).getquantity(),k.get(i).getprice(),k.get(i).getdate()));
				tvData.refresh();
			}
			
			colid.setCellValueFactory(new PropertyValueFactory<>("idsupply"));
			colwine.setCellValueFactory(new PropertyValueFactory<>("idwine"));
			colcustomer.setCellValueFactory(new PropertyValueFactory<>("idsupplier"));
			colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
			coldate.setCellValueFactory(new PropertyValueFactory<>("datesupply"));
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
