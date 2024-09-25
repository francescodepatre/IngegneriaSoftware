package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
			
			System.out.println("connecting to the database...");
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn != null) {
				System.out.println("Connection to sql is successful!");
			}
			else {
				System.out.println("Failed to connect to sql...");
				System.exit(0);
			}
			
			System.out.println("creating a statement...");
			Statement stmt = conn.createStatement();
			
			if(stmt != null) {
				System.out.println("Statement creation is successful!");
			}
			else {
				System.out.println("Failed to creating a statement...");
				System.exit(0);
			}
				
			String strSelect = "SELECT ADD(Total_price) " + " FROM Purchase " + " WHERE MONTH(Date_purchase) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			total_entraces = rset.getFloat("Total_price");
				
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
			
			System.out.println("connecting to the database...");
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn != null) {
				System.out.println("Connection to sql is successful!");
			}
			else {
				System.out.println("Failed to connect to sql...");
				System.exit(0);
			}
			
			System.out.println("creating a statement...");
			Statement stmt = conn.createStatement();
			
			if(stmt != null) {
				System.out.println("Statement creation is successful!");
			}
			else {
				System.out.println("Failed to creating a statement...");
				System.exit(0);
			}
				
			String strSelect = "SELECT ADD(Total_price) " + " FROM Supply " + " WHERE MONTH(Date_supply) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			total_exites = rset.getFloat("Total_price");
				
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
			
			System.out.println("connecting to the database...");
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn != null) {
				System.out.println("Connection to sql is successful!");
			}
			else {
				System.out.println("Failed to connect to sql...");
				System.exit(0);
			}
			
			System.out.println("creating a statement...");
			Statement stmt = conn.createStatement();
			
			if(stmt != null) {
				System.out.println("Statement creation is successful!");
			}
			else {
				System.out.println("Failed to creating a statement...");
				System.exit(0);
			}
				
			String strSelect = "SELECT ADD(Quantity) " + " FROM Supply " + " WHERE MONTH(Date_supply) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			total_s = rset.getInt("Quantity");
				
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
			
			System.out.println("connecting to the database...");
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn != null) {
				System.out.println("Connection to sql is successful!");
			}
			else {
				System.out.println("Failed to connect to sql...");
				System.exit(0);
			}
			
			System.out.println("creating a statement...");
			Statement stmt = conn.createStatement();
			
			if(stmt != null) {
				System.out.println("Statement creation is successful!");
			}
			else {
				System.out.println("Failed to creating a statement...");
				System.exit(0);
			}
				
			String strSelect = "SELECT ADD(Quantity) " + " FROM Purchase " + " WHERE MONTH(Date_supply) = " + month + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			total_p = rset.getInt("Quantity");
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return total_p;
	}
	
	public void monthly_report() {
		LocalDate current = LocalDate.now();
		
		System.out.println("Report of "+ current.getMonth());
		System.out.println("Entraces: " + entraces(current.getMonthValue()));
		System.out.println("Exites: "+ exites(current.getMonthValue()));
		System.out.println("Bottles selled: "+ selled_bottles(current.getMonthValue()));
		System.out.println("Bottles purchased: "+ purchased_bottles(current.getMonthValue()));
		
	}

}
