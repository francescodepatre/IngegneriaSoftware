package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actors.Customer;
import Actors.customer_output;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Customer_searchbysurname {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<Customer> customer_srcbysurn(final String customer_sur) {
		int id_customer = 0;
		String name_customer = "",surname_customer = "",code_customer = "",email_customer = "",address_customer = "",phone_customer = "",username_customer="",password_customer="";
		ArrayList<Customer> customer_out = new ArrayList<Customer>();
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT IDCustomer, Name, Surname, Code, Email, Address, Phone " + " FROM customer " + " WHERE customer.Surname = " + customer_sur;
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				id_customer = rset.getInt("IDCustomer");
				name_customer = rset.getString("Name");
				surname_customer = rset.getString("Surname");
				code_customer = rset.getString("Code");
				email_customer = rset.getString("Email");
				address_customer = rset.getString("Address");
				phone_customer = rset.getString("Phone");
				username_customer = "";
				password_customer = "";
				
				customer_out.add(new Customer(id_customer,name_customer,surname_customer,code_customer,email_customer,phone_customer,address_customer,username_customer,password_customer));
			}
				conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return customer_out;
	}
}
