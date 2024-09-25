package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class type_account {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public String get_type(final int uid) {
		
		
		String Type_result = "";
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT TypeAccount " + "FROM login_profile "+ "WHERE login_profile.UID = " + uid;
				
				ResultSet rset = stmt.executeQuery(strSelect);
				
				if(rset == null) {
					System.out.println("UID doesn't exist in database...");
				}
				
				while(rset.next()) {
					Type_result = rset.getString("TypeAccount");
				}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return Type_result;
	}
	
}
