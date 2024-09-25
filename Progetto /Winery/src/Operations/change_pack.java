package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class change_pack {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void change_seller_password(final String new_password,final int idseller) {
	
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_pswd = "update seller set seller.Password = '"+ new_password + "' where seller.IDSeller = "+ idseller + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(change_pswd);
			
			pstmt.executeUpdate(change_pswd);
			
			System.out.println("Password Updated correctly");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	public void change_seller_username(final String new_username,final int idseller) {
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
			String change_pswd = "update seller set seller.Username = '"+ new_username + "' where seller.IDSeller = "+ idseller + ";" ;
			
			PreparedStatement pstmt = conn.prepareStatement(change_pswd);
			
			pstmt.executeUpdate(change_pswd);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
