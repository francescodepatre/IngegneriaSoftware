package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Actors.Wine;

public class add_new_wine {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void wine_add(final Wine wine) {
		
		try {
			String strinsert = "INSERT INTO wine VALUES(?, ?, ?, ?, ?)";
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			PreparedStatement pstmt = conn.prepareStatement(strinsert);
			
				
			pstmt.setInt(1, wine.getwine_id());
			pstmt.setString(2, wine.get_name());
			pstmt.setInt(3, wine.get_year());
			pstmt.setDouble(4, wine.get_price());
			pstmt.setInt(5, wine.get_quantity());
			pstmt.addBatch();
			
			pstmt.executeBatch();	
			
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}


