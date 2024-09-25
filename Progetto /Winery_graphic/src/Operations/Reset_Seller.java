package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Reset_Seller {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Seller_rst(final int seller_id) {
		String new_username = "seller", new_password = "seller";
			
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
				
			
			String strUpdate = "UPDATE seller SET seller.Username = " + "'" + new_username + "'" + " , " + "seller.Password = " + "'" + new_password + "'" + " WHERE seller.IDSeller = " + seller_id;
			
			stmt.executeUpdate(strUpdate);
			
			System.out.println("Database updated successfully! ");
			
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Reset_Seller().Seller_rst(22);
	}
}
