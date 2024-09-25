package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Actors.Wine;

public class Remove_quantity {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void rmv(final Wine wine, final int quantity ) {
	
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
				
			String add_quantity = "update wine set wine.Quantity = wine.Quantity - "+ quantity + " where wine.IDWine = "+ wine.get_id() + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(add_quantity);
			
			pstmt.executeUpdate(add_quantity);
			
			System.out.println("Quantity removed successfully");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
