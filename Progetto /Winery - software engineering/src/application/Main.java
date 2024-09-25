package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load()
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Welcome to winery!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void main_login_button_is_pressed(ActionEvent e) {
		System.out.println("Login");
	}
	public void main_register_button_is_pressed(ActionEvent e) {
		System.out.println("Register");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
