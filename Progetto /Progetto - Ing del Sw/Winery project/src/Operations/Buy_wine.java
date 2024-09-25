package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import Actors.*;

public class Buy_wine {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void buy(final Wine wine, final int quantity, final Customer cus, final String method) {
		double total_price;
		Random rnd = new Random();
		long millis = System.currentTimeMillis();
		java.sql.Date today = new java.sql.Date(millis);
		
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
			int id_p = rnd.nextInt(9999999);
			
			String insertSql = "insert into purchase (" + id_p + "," + wine.get_id() + "," + quantity + "," +  total_price + "," + today + "," + cus.get_id() + "," + method + ");";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			
			pstmt.executeBatch();
			
			System.out.println("Purchase compiled successfully");
			
			new Remove_quantity().rmv(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
