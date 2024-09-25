package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.proposal;

public class Remove_proposal {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void remove(final int idp) {
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
				
			String rmv_quantity = "delete from proposal where proposal.IDProposal = "+ idp + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(rmv_quantity);
			
			pstmt.executeUpdate(rmv_quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	
	public void update(final int idp, final int idsel) {
			
			try {
				
				Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
				Statement stmt = conn.createStatement();
				
				String rmv_quantity = "Update proposal set proposal.Seller_sign = " + idsel +" where proposal.IDProposal = "+ idp + ";" ;
				PreparedStatement pstmt = conn.prepareStatement(rmv_quantity);
				
				pstmt.executeUpdate(rmv_quantity);
	
			}
			catch (SQLException e) {
				e.printStackTrace();
				}
			
			}
	public void add_to_purchase(final int idprop,final int idcus) {
		proposal prp = new proposal_searchid().proposal_src(idprop);
		new Buy_wine().buy(new Wine_searchID().wine_id(prp.getIdWine()), prp.getQuantity(), new Customer_constructor().cutsm_con(idcus), "Credit Card");
		new Remove_proposal().remove(idprop);
	}
}
