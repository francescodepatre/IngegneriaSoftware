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
	
	public void rmv(final Wine wine, final int q) {
	
		try {
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			String add_quantity = "update wine set wine.Quantity = wine.Quantity - "+ q + " where wine.IDWine = "+ wine.getwine_id() + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(add_quantity);
			
			pstmt.executeUpdate(add_quantity);	
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
