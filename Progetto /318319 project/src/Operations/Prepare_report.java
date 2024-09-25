package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * report mensile sullo stato dell’azienda 
 * introiti
 * spese
 * numero bottiglie vendute e disponibili alla vendita 
 * numero di vendite per i diversi vini
 * valutazione dei dipendenti
 */

public class Prepare_report {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public float entraces(final int month) {
		float total_entraces = 0;
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);

			Statement stmt = conn.createStatement();
				
			String strSelect = "SELECT SUM(purchase.Total_price) as te" + " FROM purchase " + " WHERE MONTH(purchase.Date_purchase) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()){
				total_entraces = rset.getFloat("te");
			}

			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total_entraces;
	}
	public float exites(final int month) {
		float total_exites = 0;
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);

			Statement stmt = conn.createStatement();
				
			String strSelect = "SELECT SUM(supply.Total_price) as tp" + " FROM supply " + " WHERE MONTH(supply.Date_supply) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()){
				total_exites = rset.getFloat("tp");
			}

			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return total_exites;
	}
	public int purchased_bottles(final int month) {
		int total_s = 0;
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);

			Statement stmt = conn.createStatement();

			String strSelect = "SELECT SUM(supply.Quantity) as bot " + " FROM supply " + " WHERE MONTH(supply.Date_supply) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()){
				total_s = rset.getInt("bot");
			}

			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return total_s;
	}
	public int selled_bottles(final int month) {
		int total_p = 0;
		try {

			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);

			Statement stmt = conn.createStatement();

			String strSelect = "SELECT SUM(purchase.Quantity) as sld" + " FROM purchase " + " WHERE MONTH(purchase.Date_purchase) = " + month + ";";

			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()){
				total_p = rset.getInt("sld");
			}

			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return total_p;
	}
	public int n_wines(final int month) {
		int total_s = 0;
		try {

			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);

			Statement stmt = conn.createStatement();

			String strSelect = "SELECT SUM(supply.Quantity) as bot " + " FROM supply " + " WHERE MONTH(supply.Date_supply) = " + month + ";";

			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()){
				total_s = rset.getInt("bot");
			}

			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return total_s;
	}

	public void produce_montly_report(){
		LocalDate current = LocalDate.now();
		try{
			File report_file = new File("Reports/report_of_" + current.getMonth() + ".txt");

			if(report_file.createNewFile()){
				System.out.println("File created");
			}
			else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Attention");
				alert.setHeaderText("File Already Exists");
				alert.showAndWait();
			}

			FileWriter report_writer = new FileWriter("Reports/report_of_" + current.getMonth() + ".txt");
			report_writer.write("Report of "+ current.getMonth() + "\n");
			report_writer.write("Entraces: " + entraces(current.getMonthValue()) + "\n");
			report_writer.write("Exites: "+ exites(current.getMonthValue()) + "\n");
			report_writer.write("Bottles selled: "+ selled_bottles(current.getMonthValue()) + "\n");
			report_writer.write("Bottles purchased: "+ purchased_bottles(current.getMonthValue()) + "\n");
			report_writer.close();

		}catch (IOException e){
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
	}
}
