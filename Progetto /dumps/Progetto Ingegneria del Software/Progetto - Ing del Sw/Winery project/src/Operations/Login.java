package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Login {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery?";
	private final String LOGIN = "root";
	private final String PASSWORD = "root";
	
	public void Login_mechanism() {
		
		Scanner s = new Scanner(System.in);
		
		try (Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				Statement stmt = conn.createStatement();)
		{
			/*
				String create = "CREATE VIEW IF NOT EXISTS profiles_login(UID, Uname, Passwd, Type) " +
						"(SELECT admin.IDAdmin, admin.Username, admin.Password, admin.Type " +
						" FROM admin " +
						" UNION " +
						" SELECT seller.IDSeller, seller.Username, seller.Password, seller.Type" +
						" FROM seller " +
						" UNION " +
						" SELECT customer.IDCustomer, customer.Username, customer.Password, customer.Type " +
						" FROM customer ";
				
				stmt.executeUpdate(create);
				*/
			
			int UID_result = 0,UID_request = 0;
			String Uname_result = "", Passwd_result = "", Type_result = "";
			Boolean Login_Status = false;
			
			System.out.println("Enter UID: ");
			UID_request = s.nextInt();
			
			System.out.println("Enter Username: ");
			String Username_request = s.next();
			
			System.out.println("Enter Password: ");
			String Password_request = s.next();
			
			//aggiungere clausola WHERE con i dati immessi nella finestra di login
				String strSelect = "SELECT UID, Uname, Passwd, profile, Type " +
				"FROM profiles_login "+ "WHERE profile_login." + UID_request;
				
				ResultSet rset = stmt.executeQuery(strSelect);
				
				while(rset.next()) {
					UID_result = rset.getInt("UID");
					Uname_result = rset.getString("Uname");
					Passwd_result = rset.getString("Passwd");
					Type_result = rset.getString("Type");
				}
				
				//aggiungere controllo per verificare che il contenuto immesso nella finestra sia corretto
				if(UID_result == UID_request) {
					if(Uname_result == Username_request) {
						if(Passwd_result == Password_request) {
							Login_Status = true;
						}
						else {
							System.out.println("Password Errata.");
						}
					}
					else {
						System.out.println("Username Errato");
						Login_Status = false;
					}
					System.out.println("UID errato");
					Login_Status = false;
				}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(final String[] args) {
		new Login().Login_mechanism();
	}
}
