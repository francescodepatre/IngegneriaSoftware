package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Scanner;

public class Get_info{
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void compile_supply(final int id_prop) {
	
	int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
	double total_proposal = 0.0;
	Date date_proposal = Date.valueOf("1970-1-1");
	Date date_compilation = Date.valueOf("1970-1-1");
	
	try {
		
		Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
		
		Statement stmt = conn.createStatement();
		
		String strSelect = "select * from proposal where proposal.IDProposal = " + id_prop + ";";
		
		ResultSet rset = stmt.executeQuery(strSelect);
		
		while(rset.next()){
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
			
		conn.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
	public Wine getProposalWine(final int id_prop) {
		
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
		double total_proposal = 0.0;
		Date date_proposal = Date.valueOf("1970-1-1");
		Date date_compilation = Date.valueOf("1970-1-1");
		Wine wine_output = new Wine(0, "", 0, 0, 0);
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "select * from proposal where proposal.IDProposal = " + id_prop + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()){
				id_proposal = rset.getInt("IDProposal");
				id_wine = rset.getInt("ID_wine");
				id_customer = rset.getInt("ID_customer");
				quantity = rset.getInt("Quantity");
				date_proposal = rset.getDate("Date_proposal");
				total_proposal = rset.getFloat("Total_proposal");
				date_compilation = rset.getDate("Date_compilation");
				seller_sign = rset.getInt("Seller_sign");
				id_sel = rset.getInt("ID_seller");
				
				wine_output = new Wine_searchID().wine_id(id_wine);
			}
				
			conn.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return wine_output;
	}
	
public int getProposalQuantity(final int id_prop) {
		
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, seller_sign = 0, id_sel = 0; 
		double total_proposal = 0.0;
		Date date_proposal = Date.valueOf("1970-1-1");
		Date date_compilation = Date.valueOf("1970-1-1");
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "select * from proposal where proposal.IDProposal = " + id_prop + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()){
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
				
			conn.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return quantity;
	}
}
