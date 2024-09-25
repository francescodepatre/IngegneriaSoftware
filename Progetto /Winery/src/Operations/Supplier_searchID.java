package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.Supplier;

public class Supplier_searchID {


	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public Supplier supplier_id(int suppid) {
		
		int id_supplier = 0;
		String name_supplier = "", address_supplier = "", phone_supplier = "";
		Supplier supp = new Supplier(id_supplier,name_supplier,address_supplier,phone_supplier);
		
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
				
			String strSelect = "SELECT * " + " FROM supplier " + " WHERE supplier.IDSupplier = " + "'" + suppid + "'";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			
			while(rset.next()) {
				id_supplier = rset.getInt("IDSupplier");
				name_supplier = rset.getString("Company_name");
				address_supplier = rset.getString("Address");
				phone_supplier = rset.getString("Phone");
				
			}
			
			supp = new Supplier(id_supplier,name_supplier,address_supplier,phone_supplier);
			
			
			conn.close();
			
			
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return supp;
		
	}

}
