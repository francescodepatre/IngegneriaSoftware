package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Actors.proposal;

public class proposal_searchid {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public proposal proposal_src(final int id) {
		
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
		double total_proposal = 0.0;
		Date date_proposal = Date.valueOf("1970-1-1");
		Date date_compilation = Date.valueOf("1970-1-1");
		proposal prop_output = new proposal();
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT * FROM proposal WHERE proposal.IDProposal = " + id + ";";
			
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
				
				prop_output.setId(id_proposal);
				prop_output.setIdWine(id_wine);
				prop_output.setIdCustomer(id_customer);
				prop_output.setQuantity(quantity);
				prop_output.setDate(date_proposal.toString());
				prop_output.setTotal(total_proposal);
				prop_output.setDateCompilation(date_compilation.toString());
				prop_output.setSellerSign(seller_sign);
				prop_output.setSellerID(id_sel);
				
			}
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prop_output;
	}
}
