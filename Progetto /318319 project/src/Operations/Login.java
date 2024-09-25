package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Login {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public int Login_mechanism(final String Username_request,final String Password_request) {
		
		int UID_result = 0,UID_request = 0;
		String Uname_result = "", Passwd_result = "", Type_result = "";
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn == null) {
				System.exit(0);
			}
			
			Statement stmt = conn.createStatement();
			
			if(stmt == null) {
				System.exit(0);
			}
			
			UID_request = new get_general_id().get_uid(Username_request, Password_request);
			
			String strSelect = "SELECT UID, Uname, Passwd, TypeAccount FROM login_profile WHERE login_profile.UID = " + UID_request;
				
			ResultSet rset = stmt.executeQuery(strSelect);
				
				while(rset.next()) {
					UID_result = rset.getInt("UID");
					Uname_result = rset.getString("Uname");
					Passwd_result = rset.getString("Passwd");
					Type_result = rset.getString("TypeAccount");
				}
				
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return UID_result;
	}
	
}
