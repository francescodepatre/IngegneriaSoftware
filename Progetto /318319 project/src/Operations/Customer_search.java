package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Customer_search {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void customer_src(final int customer_id) {
		int id_customer = 0;
		String name_customer = "",surname_customer = "",code_customer = "",email_customer = "",address_customer = "",phone_customer = "";
			
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
				
			
			String strSelect = "SELECT IDCustomer, Name, Surname, Code, Email, Address, Phone " + " FROM customer " + " WHERE customer.IDCustomer = " + customer_id;
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				id_customer = rset.getInt("IDCustomer");
				name_customer = rset.getString("Name");
				surname_customer = rset.getString("Surname");
				code_customer = rset.getString("Code");
				email_customer = rset.getString("Email");
				address_customer = rset.getString("Address");
				phone_customer = rset.getString("Phone");
			}
				
		
			System.out.println(" ");
			System.out.println("ID: "+ id_customer);
			System.out.println("Name: "+name_customer);
			System.out.println("Surname: "+surname_customer);
			System.out.println("Code: "+code_customer);
			System.out.println("Email: "+email_customer);
			System.out.println("Address: "+address_customer);
			System.out.println("Phone: "+phone_customer);
			System.out.println(" ");
				
				conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
