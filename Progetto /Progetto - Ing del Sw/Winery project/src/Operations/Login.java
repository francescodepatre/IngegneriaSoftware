package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import Operations.*;



public class Login {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public int Login_mechanism() {
		
		Scanner s = new Scanner(System.in);
		int UID_result = 0,UID_request = 0;
		String Uname_result = "", Passwd_result = "", Type_result = "";
		
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
			
			System.out.println("Enter Username: ");
			String Username_request = s.next();
			
			System.out.println("Enter Password: ");
			String Password_request = s.next();
			
			UID_request = new get_general_id().get_uid(Username_request, Password_request);
			
			String strSelect = "SELECT UID, Uname, Passwd, TypeAccount FROM login_profile WHERE login_profile.UID = " + UID_request;
				
			ResultSet rset = stmt.executeQuery(strSelect);
				
				if(rset == null) {
					System.out.println("UID doesn't exist in database...");
				}
				
				while(rset.next()) {
					UID_result = rset.getInt("UID");
					Uname_result = rset.getString("Uname");
					Passwd_result = rset.getString("Passwd");
					Type_result = rset.getString("TypeAccount");
					System.out.println("UID: "+ UID_result);
					System.out.println("Username: "+ Uname_result);
					System.out.println("Password: "+ Passwd_result);
				}
				
				if(UID_request == UID_result) {
					System.out.println("UID match!");
					if(Username_request.equalsIgnoreCase(Uname_result)) {
						System.out.println("Username match!");
						if(Password_request.equalsIgnoreCase(Passwd_result)) {
							System.out.println("Password match");
						}
						else {
							System.out.println("Wrong Password!");
						}
					}
					else {
						System.out.println("Wrong Username!");
					}
				}
		
				
				
				System.out.println("TypeAccount: "+Type_result);
				
				s.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return UID_result;
	}
	
}
