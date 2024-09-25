package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class Purchase_search {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Purchase_src(final Date date_start, final Date date_end) {
		
		int id_order = 0, id_wine = 0, quantity = 0, id_customer = 0; 
		double total_price = 0.0;
		Date date_order = Date.valueOf("1-1-1970");
		
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
				
			String strSelect = "SELECT * " + " FROM Orders " + " WHERE (Orders.Date_order > " +  date_start.toString() + ") AND (Orders.Date_order < " + date_end.toString() + ");";
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				
				id_order = rset.getInt("IDOrder");
				id_wine = rset.getInt("ID_wine");
				quantity = rset.getInt("Quantity");
				total_price = rset.getFloat("Total_price");
				date_order = rset.getDate("Dade_order");
				id_customer = rset.getInt("ID_customer");
				
			}
			
			System.out.println(" ");
			System.out.println("ID: "+ id_order);
			System.out.println("ID wine: "+ id_wine);
			System.out.println("Quantity: "+ quantity);
			System.out.println("Total price: "+ total_price);
			System.out.println("Date: "+ date_order);
			System.out.println("ID customer: "+ id_customer);
			System.out.println(" ");
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
