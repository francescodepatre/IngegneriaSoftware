package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Reset_seller {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Seller_rst(final int seller_id) {
		String new_username = "seller", new_password = "seller";
			
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strUpdate = "UPDATE seller SET seller.Username = " + "'" + new_username + "'" + " , " + "seller.Password = " + "'" + new_password + "'" + " WHERE seller.IDSeller = " + seller_id;
			
			stmt.executeUpdate(strUpdate);
						
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
