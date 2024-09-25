package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actors.proposal;

public class searchproposalbyid {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<proposal> proposal_ser(final int sellid) {
		
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
		double total_proposal = 0.0;
		Date date_proposal = Date.valueOf("1970-1-1");
		Date date_compilation = Date.valueOf("1970-1-1");
		ArrayList<proposal> list_output = new ArrayList<proposal>();
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT * FROM proposal WHERE proposal.ID_seller = " +  sellid + ";";
			
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
				
				if(date_compilation != null) {
					list_output.add(new proposal(id_proposal,id_wine,id_customer,quantity,date_proposal.toString(),total_proposal,date_compilation.toString(),seller_sign,id_sel));
				}
				else if(date_compilation == null) {
					list_output.add(new proposal(id_proposal,id_wine,id_customer,quantity,date_proposal.toString(),total_proposal,"null",0,id_sel));
				}
				
			}
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list_output;
	}
}
