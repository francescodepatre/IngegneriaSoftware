package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Random_seller {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public int rand_sel() {
		int result = 0;
		ArrayList result_array = new ArrayList();
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
				
			
			String strSelect = "SELECT seller.IDSeller FROM seller ORDER BY RAND()";
			
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()) {
				result = rset.getInt("IDSeller");
			}

				conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

