package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actors.purchase;

import java.sql.Date;

public class Purchase_search {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<purchase> Purchase_src(final String date_start, final String date_end) {
		
		int id_order = 0, id_wine = 0, quantity = 0, id_customer = 0; 
		double total_price = 0.0;
		Date date_order = Date.valueOf("1970-1-1");
		String meth = "";
		ArrayList<purchase> outputlist = new ArrayList<purchase>();
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
				
			String strSelect = "SELECT * FROM Purchase WHERE Purchase.Date_purchase > '" +  date_start + "' AND Purchase.Date_purchase < '" + date_end + "';";
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				id_order = rset.getInt("IDOrder");
				id_wine = rset.getInt("ID_wine");
				quantity = rset.getInt("Quantity");
				total_price = rset.getFloat("Total_price");
				date_order = rset.getDate("Date_purchase");
				id_customer = rset.getInt("ID_customer");
				meth = rset.getString("Payment_method");
				
				outputlist.add(new purchase(id_order,id_wine,quantity,total_price,date_order.toString(),id_customer,meth));
			}
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return outputlist;
	}
}
