package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			
			new Remove_quantity().rmv(wine, quantity);
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			total_price = wine.get_price() * quantity;
			
			int id_p = rnd.nextInt(9999999);
			
			String insertSql = "insert into purchase (" + id_p + "," + wine.getwine_id() + "," + quantity + "," +  total_price + "," + today + "," + cus.get_id() + "," + method + ");";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			
			pstmt.executeBatch();
			
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
