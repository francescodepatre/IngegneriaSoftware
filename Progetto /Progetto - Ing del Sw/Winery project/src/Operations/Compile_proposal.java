package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import Actors.Customer;
import Actors.Wine;

public class Compile_proposal {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void prop(final Wine wine, final int quantity, final Customer cus) {
		double total_price;
		Random rnd = new Random();
		long millis = System.currentTimeMillis();
		java.sql.Date today = new java.sql.Date(millis);
		
		
		try {
			
			System.out.println("connecting to database...");
			
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
			
			total_price = wine.get_price() * quantity;
			int id_p = rnd.nextInt(9999999);
			
			int id_oper = new Random_seller().rand_sel();
			String insertSql = "insert into proposal (" + id_p + "," + wine.get_id() + "," + cus.get_id() + "," +  quantity + "," + today + "," + total_price + "," + null + "," + 0 + "," + id_oper + ");";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			
			pstmt.executeBatch();
			
			System.out.println("Proposal compiled successfully");
			
			new Remove_quantity().rmv(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
