package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Change_admin_password {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void change_password(final String new_password,final int idAdmin) {
	
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_pswd = "update admin set admin.Password = '"+ new_password + "' where admin.IDAdmin = "+ idAdmin + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(change_pswd);
			
			pstmt.executeUpdate(change_pswd);
			
			System.out.println("Password Updated correctly");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	public void change_username(final String new_username,final int idAdmin) {
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_pswd = "update admin set admin.Username = '"+ new_username + "' where admin.IDAdmin = "+ idAdmin + ";" ;
			
			PreparedStatement pstmt = conn.prepareStatement(change_pswd);
			
			pstmt.executeUpdate(change_pswd);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
