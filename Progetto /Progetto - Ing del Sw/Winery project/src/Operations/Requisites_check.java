package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Requisites_check {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public Boolean seller_check() {
	
		Boolean seller_req = false;
		int n_seller = 0;
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
				
			String strSelect = "SELECT COUNT(seller.IDSeller) " + " FROM seller ";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			
			while(rset.next()) {
				n_seller = rset.getInt("count(seller.IDSeller)");				
			}
			
			if(n_seller < 3) {
				seller_req = false;
				conn.close();
				System.err.println("Failed to start: not enough sellers. (You have "+n_seller+" sellers)");
				System.exit(0);
			}
			else {
				seller_req = true;
			}
			conn.close();
			
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seller_req;
		
	}
	
	public Boolean wine_check() {
		
		Boolean wine_req = false;
		int n_wine = 0;
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
				
			String strSelect = "SELECT COUNT(wine.IDWine) " + " FROM wine ";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			
			while(rset.next()) {
				n_wine = rset.getInt("count(wine.IDWine)");				
			}
			
			if(n_wine < 10) {
				wine_req = false;
				conn.close();
				System.err.println("Failed to start: not enough wines. (You have "+n_wine+" wines)");
				System.exit(0);
			}
			else {
				wine_req = true;
			}
			conn.close();
			
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wine_req;
		
	}
	
	public boolean starting_check() {
		
		if(wine_check() && seller_check()) {
			System.out.println("All requisities are satisfied! ");
			return true;
		}
		else {
			return false;
		}
	}

}
