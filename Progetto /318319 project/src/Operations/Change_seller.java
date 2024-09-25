package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Change_seller {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void change_password(final String new_password,final int idSeller) {
	
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_pswd = "update seller set seller.Password = '"+ new_password + "' where seller.IDSeller = "+ idSeller + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(change_pswd);
			
			pstmt.executeUpdate(change_pswd);
			
			System.out.println("Password Updated correctly");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	public void change_username(final String new_username,final int idSeller) {
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_usrnm = "update seller set seller.Username = '"+ new_username + "' where seller.IDSeller = "+ idSeller + ";" ;
			
			PreparedStatement pstmt = conn.prepareStatement(change_usrnm);
			
			pstmt.executeUpdate(change_usrnm);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
}