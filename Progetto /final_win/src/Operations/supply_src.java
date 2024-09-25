package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actors.supply;

public class supply_src {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<supply> Supply_src(final int suppid) {
		
		int id_supply = 0, id_wine = 0, quantity = 0, id_supplier = 0; 
		double total_price = 0.0;
		Date date_order = Date.valueOf("1970-1-1");
		ArrayList<supply> list = new ArrayList<supply>();
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT * FROM supply WHERE supply.ID_supplier = " + suppid + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			while(rset.next()) {
				
				id_supply = rset.getInt("IDSupply");
				id_wine = rset.getInt("ID_wine");
				quantity = rset.getInt("Quantity");
				total_price = rset.getFloat("Total_price");
				date_order = rset.getDate("Date_supply");
				id_supplier = rset.getInt("ID_supplier");
				list.add(new supply(id_supply,id_wine,id_supplier,quantity,total_price,date_order.toString()));
				
			}
				
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
