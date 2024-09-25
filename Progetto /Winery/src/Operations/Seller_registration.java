package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.Seller;
import java.util.Random;

public class Seller_registration {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Seller_reg(final String Name,final String Surname,final String Code,final String Email,final String Phone,final String Address,final String Username,final String Password) {
		
		try {
			int ID;
			String strinsert = "INSERT INTO seller VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String TypeAccount = "Seller";
			
			Random rnd = new Random();
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			PreparedStatement pstmt = conn.prepareStatement(strinsert);
			
			ID = rnd.nextInt(99, 999);
		
			Seller new_profile = new Seller(ID,Name,Surname,Code,Email,Phone,Address,Username,Password);
				
				
			pstmt.setInt(1, new_profile.get_id());
			pstmt.setString(2, new_profile.get_name());
			pstmt.setString(3, new_profile.get_surname());
			pstmt.setString(4, new_profile.get_code());
			pstmt.setString(5, new_profile.get_email());
			pstmt.setString(6, new_profile.get_phone());
			pstmt.setString(7, new_profile.get_address());
			pstmt.setString(8, new_profile.get_username());
			pstmt.setString(9, new_profile.get_password());
			pstmt.setString(10, TypeAccount);
			pstmt.addBatch();
			
			pstmt.executeBatch();	
			
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
