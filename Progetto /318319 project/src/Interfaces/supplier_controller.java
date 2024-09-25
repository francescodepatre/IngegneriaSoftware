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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class supplier_controller{

	@FXML
	private TableView<supply_output> tvData;
	@FXML
	private TableColumn<String, String> idcol;
	@FXML
	private TableColumn<String, String> winecol;
	@FXML
	private TableColumn<String, String> suppliercol;
	@FXML
	private TableColumn<String, String> quantitycol;
	@FXML
	private TableColumn<String, String> pricecol;
	@FXML
	private TableColumn<String, String> datesupplycol;

	private ObservableList<supply_output> tvObservableList =
		      FXCollections.observableArrayList();
		
		private Client cli;
		
		public void setclient(final Client c) {
			this.cli = c;
		}
		
		
		
		public void searchbuttonpressed(ActionEvent e) throws IOException, ClassNotFoundException{
			
			Object inputsocket = cli.receiveData();
			
			ArrayList<supply> k = (ArrayList<supply>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new supply_output(k.get(i).getid(),k.get(i).getwine(),k.get(i).getsupplier(),k.get(i).getquantity(),k.get(i).getprice(),k.get(i).getdate()));
				tvData.refresh();
			}
			
			idcol.setCellValueFactory(new PropertyValueFactory<>("idsupply"));
			winecol.setCellValueFactory(new PropertyValueFactory<>("idwine"));
			suppliercol.setCellValueFactory(new PropertyValueFactory<>("idsupplier"));
			quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
			datesupplycol.setCellValueFactory(new PropertyValueFactory<>("datesupply"));
		    tvData.setItems(tvObservableList);
			
		}
		
		public void cancelbuttonpressed(ActionEvent e) throws IOException{
			System.exit(0);
		}
}
