package Operations;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Random;
import Actors.Customer;

public class Registration {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Customer_reg(final String Name, final String Surname,final String Code, final String Email, final String Phone, final String Address, final String Username, final String Password) {
		
		try {
			int ID;
			String strinsert = "INSERT INTO seller VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String TypeAccount = "Customer";
			
			System.out.println("Triyng to connect to the database...");
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			if(conn != null) {
				System.out.println("Connection is successful!");
			}
			
			System.out.println("Creating a statement...");
			
			PreparedStatement pstmt = conn.prepareStatement(strinsert);
			
			if(pstmt != null) {
				System.out.println("Prepared statement creation is successful! ");
			}
			
			Random rnd = new Random();
			
			ID = rnd.nextInt(111111, 999999);
			
			Customer new_profile = new Customer(ID,Name,Surname,Code,Email,Phone,Address,Username,Password);
				
				
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
			
			System.out.println("Registration complete!");			
		      
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}