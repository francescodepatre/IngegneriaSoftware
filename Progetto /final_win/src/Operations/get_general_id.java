package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class get_general_id {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public int get_uid(final String username, final String password) {
		
		int id_result = 0;
		
		try {
						
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT UID FROM login_profile WHERE login_profile.Uname = '" + username + "' AND login_profile.Passwd = '" + password + "';";
				
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				id_result = rset.getInt("UID");
			}
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return id_result;
	}
}

