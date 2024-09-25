package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Actors.Customer;

public class Customer_constructor {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public Customer cutsm_con(final int id) {
		
		Customer custm = new Customer(0,"","","","","","","","");
		
		
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
				
			String strSelect = "SELECT * " + " FROM customer " + " WHERE customer.IDCustomer = " + "'" + id;
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			
				
			while(rset.next()) {
				int id_customer = rset.getInt("IDCustomer");
				String name_customer = rset.getString("Name");
				String surname_customer = rset.getString("Surname");
				String code_customer = rset.getString("Code");
				String email_customer = rset.getString("Email");
				String address_customer = rset.getString("Address");
				String phone_customer = rset.getString("Phone");
				String username_customer = rset.getString("Username");
				String password_customer = rset.getString("Password");
				
				custm = new Customer(id_customer,name_customer,surname_customer,code_customer,email_customer,address_customer,phone_customer,username_customer,password_customer);
			}
				
			conn.close();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return custm;
	}
	

}
