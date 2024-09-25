package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.*;
import java.util.Scanner;

public class Get_info{
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void compile_supply(final int id_prop) {
	
	int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
	double total_proposal = 0.0;
	Date date_proposal = Date.valueOf("1-1-1970");
	Date date_compilation = Date.valueOf("1-1-1970");
	
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
			
		String strSelect = "select * from proposal where proposal.IDProposal = " + id_prop + ";";
		
		ResultSet rset = stmt.executeQuery(strSelect);
		
		Scanner s = new Scanner(System.in);
			
		id_proposal = rset.getInt("IDOrder");
		id_wine = rset.getInt("ID_wine");
		id_customer = rset.getInt("ID_customer");
		quantity = rset.getInt("Quantity");
		date_proposal = rset.getDate("Dade_proposal");
		total_proposal = rset.getFloat("Total_proposal");
		date_compilation = rset.getDate("Date_compilation");
		seller_sign = rset.getInt("Seller_sign");
		id_sel = rset.getInt("ID_seller");
		
		System.out.println("Inserisci id fornitore: ");
		int id_sup = s.nextInt();
		Supplier sup = new Supplier_searchID().supplier_id(id_sup);
		Wine win = new Wine_searchID().wine_id(id_wine);
		new Compile_supply().compile_supply(win, sup, quantity);
		
		new Proposal_result().res(id_proposal, id_sel);
			
		conn.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
}
