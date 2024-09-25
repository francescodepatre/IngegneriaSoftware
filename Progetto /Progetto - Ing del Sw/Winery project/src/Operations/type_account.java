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
			
			
			
			String strSelect = "SELECT TypeAccount " + "FROM login_profile "+ "WHERE login_profile.UID = " + uid;
				
				ResultSet rset = stmt.executeQuery(strSelect);
				
				if(rset == null) {
					System.out.println("UID doesn't exist in database...");
				}
				
				while(rset.next()) {
					Type_result = rset.getString("TypeAccount");
				}
				
				System.out.println("TypeAccount: "+Type_result);
				
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return Type_result;
	}
	
}
