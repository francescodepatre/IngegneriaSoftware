package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.*;
/*
 * id supply
 * 
 */
public class Compile_supply {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void compile_supply(final Wine wine, final Supplier supplier, final int quantity ) {
		double total_price;
		java.util.Date javaDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(javaDate.getTime());
		
		try {
			
			System.out.println("connecting to database...");
			
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
			
			total_price = wine.get_price() * quantity;
			
			String insertSql = "insert into supply (" + wine.get_id() + "," + supplier.get_id() + "," + quantity + "," +  total_price + "," + date + ");";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			
			pstmt.executeBatch();
			
			System.out.println("Supply compiled successfully");
			
			new Add_quantity().add(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	}