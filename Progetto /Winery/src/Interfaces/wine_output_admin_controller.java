package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Actors.Wine;
import Actors.wine_output;
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

public class wine_output_admin_controller {

	@FXML
	private TableView<wine_output> tvData;
	@FXML
	private TableColumn<String, String> colId;
	@FXML
	private TableColumn<String, String> colName;
	@FXML
	private TableColumn<String, String> colAge;
	@FXML
	private TableColumn<String, String> colName1;
	@FXML
	private TableColumn<String, String> colName11;

	private ObservableList<wine_output> tvObservableList =
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
			
			ArrayList<Wine> k = (ArrayList<Wine>) inputsocket;	
			
			for(int i = 0; i < k.size(); i++) {
				tvObservableList.add(new wine_output(k.get(i).getwine_id(),k.get(i).get_name(),k.get(i).get_year(),k.get(i).get_price(),k.get(i).get_quantity()));
				tvData.refresh();
			}
			
		    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		    colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		    colAge.setCellValueFactory(new PropertyValueFactory<>("year"));
		    colName1.setCellValueFactory(new PropertyValueFactory<>("price"));
		    colName11.setCellValueFactory(new PropertyValueFactory<>("quantity"));
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