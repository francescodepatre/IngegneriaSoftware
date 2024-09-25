package Operations;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import Actors.Admin;

public class Admin_registration {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void Admin_reg() {
Scanner scn = new Scanner(System.in);
		
		try {
			String Name, Surname, Code, Email, Phone, Address, Username, Password;
			int ID;
			String strinsert = "INSERT INTO admin VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String TypeAccount = "Admin";
			
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
			
			/* controllo */
			
			Statement stmt = conn.createStatement();
			
			
			System.out.println("create an ID:");
			ID = scn.nextInt();
			
			System.out.println("Name: ");
			Name = scn.next();
			
			System.out.println("Surname: ");
			Surname = scn.next();
			
			System.out.println("Code: ");
			Code = scn.next();
			
			System.out.println("Email: ");
			Email = scn.next();
			
			System.out.println("Phone: ");
			Phone = scn.next();
			
			System.out.println("Address: ");
			Address = scn.next();
			
			System.out.println("Username: ");
			Username = scn.next();
			
			System.out.println("Password: ");
			Password = scn.next();
			
			Admin new_profile = new Admin(ID,Name,Surname,Code,Email,Phone,Address,Username,Password);
				
				
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
			
			
					
					//executeQuery(strinsert);
			
			
			
			System.out.println("Registration complete!");
			
			/*controllo se la query è andata a buon fine*/
			String strSelect = "select * from admin";
		    System.out.println("The SQL statement is: " + strSelect + "\n");

		    ResultSet rset = stmt.executeQuery(strSelect);

		    System.out.println("The new records are:\n");
		     
		    while (rset.next()){
		   	  int ID_result = rset.getInt("IDAdmin");
		      String Name_result = rset.getString("Name");
		      String Surname_result = rset.getString("Surname");
		      String Code_result = rset.getString("Code");
		      String Email_result = rset.getString("Email");
		      String Phone_result = rset.getString("Phone");
		      String Address_result = rset.getString("Address");
		      String Username_result = rset.getString("Username");
		      String Password_result = rset.getString("Password");
		      String Type_result = rset.getString("TypeAccount");
			      
		      System.out.println(ID_result + ", " + Name_result + ", "+ Surname_result + ", " + Code_result + ", "+ Email_result + ", " + Phone_result + ", " + Address_result + ", "+ Username_result + ", " + Password_result + ", "+ Type_result);
		      	}
		      
			scn.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
