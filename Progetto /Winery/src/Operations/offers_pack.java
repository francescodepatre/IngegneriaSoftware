package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actors.Offer;

public class offers_pack {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<Offer> getOffers(){
		
		ArrayList<Offer> list_output = new ArrayList<Offer>();
		Date today = new Date(System.currentTimeMillis());
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String QUERY = "SELECT * FROM offer WHERE offer.dateend > '" + today.toString() + "';";
			
			ResultSet rset = stmt.executeQuery(QUERY);
			
			while(rset.next()) {
				int idoffer = rset.getInt("idoffer");
				int codwine = rset.getInt("codwine");
				Date start = rset.getDate("datestart");
				Date end = rset.getDate("dateend");
				int discount = rset.getInt("discount");
				
				list_output.add(new Offer(idoffer,codwine,start.toString(),end.toString(),discount));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return list_output;
	}
	
	public void deleteOffer(final int idoffer) {
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strUpdate = "DELETE FROM offer WHERE offer.idoffer = " + idoffer;
			
			stmt.executeUpdate(strUpdate);
			
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addOffer(final Offer off) {
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			String strinsert = "INSERT INTO offer VALUES(" + off.getid() + "," + off.getwine() + ",'" + off.getstartingdate() + "','" + off.getendingdate() + "'," + off.getdiscount() + ");";  
			
			PreparedStatement pstmt = conn.prepareStatement(strinsert);
			
			pstmt.addBatch();
			
			pstmt.executeBatch();	
			
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Offer getLastOffer(){
			
			ArrayList<Offer> list_output = new ArrayList<Offer>();
		
			
			try {
				
				Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
				
				Statement stmt = conn.createStatement();
				
				String QUERY = "select * from offer HAVING offer.dateend >= ( SELECT MAX(offer.dateend) from offer)";
				
				ResultSet rset = stmt.executeQuery(QUERY);
				
				while(rset.next()) {
					int idoffer = rset.getInt("idoffer");
					int codwine = rset.getInt("codwine");
					Date start = rset.getDate("datestart");
					Date end = rset.getDate("dateend");
					int discount = rset.getInt("discount");
					
					list_output.add(new Offer(idoffer,codwine,start.toString(),end.toString(),discount));
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
				}
			return list_output.get(0);
		}
	public static void main(final String[] args) {
		/*
		ArrayList<Offer> l = new offers_pack().getOffers();
		for(int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getid() + "\n");
			System.out.println(l.get(i).getwine() + "\n");
			System.out.println(l.get(i).getstartingdate() + "\n");
			System.out.println(l.get(i).getendingdate() + "\n");
			System.out.println(l.get(i).getdiscount() + "\n");
		}
		*/
		Offer off = new offers_pack().getLastOffer();
		
		
		System.out.println("Offer list: " + off.toString());
		
	}
}
