package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Watch_proposal {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void watch(final int id_s) {
	
	int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
	double total_proposal = 0.0;
	Date date_proposal = Date.valueOf("1970-1-1");
	Date date_compilation = Date.valueOf("1970-1-1");
	
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
			
		String strSelect = "select * from proposal where proposal.ID_seller = " + id_s + ";";
		
		ResultSet rset = stmt.executeQuery(strSelect);
		
		while(rset.next()) {
			
			id_proposal = rset.getInt("IDProposal");
			id_wine = rset.getInt("ID_wine");
			id_customer = rset.getInt("ID_customer");
			quantity = rset.getInt("Quantity");
			date_proposal = rset.getDate("Date_proposal");
			total_proposal = rset.getFloat("Total_proposal");
			date_compilation = rset.getDate("Date_compilation");
			seller_sign = rset.getInt("Seller_sign");
			id_sel = rset.getInt("ID_seller");
		}
		
		System.out.println(" ");
		System.out.println("ID: "+ id_proposal);
		System.out.println("ID wine: "+ id_wine);
		System.out.println("ID customer: "+ id_customer);
		System.out.println("Quantity: "+ quantity);
		System.out.println("Date: "+ date_proposal);
		System.out.println("Total price: "+ total_proposal);
		System.out.println("Date: "+ date_compilation);
		System.out.println("Sign: "+ seller_sign);
		System.out.println(" ");
			
		conn.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
}