package application;
	
import Communication.Client;
import Interfaces.main_controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Client client = new Client();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main_open.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,600,400);
			main_controller controller = loader.getController();
			controller.setClient(client);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome to Winery!");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
