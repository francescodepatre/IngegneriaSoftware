package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Actors.Wine;


public class Wine_searchname {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<Wine> wine_name(final String winename) {
		
		int id_wine,year_wine,quantity_wine;
		String name_wine;
		float price_wine;
		ArrayList<Wine> output_list = new ArrayList<Wine>();
		
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
				
			String strSelect = "SELECT * " + " FROM wine " + " WHERE instr(wine.Name,"+ "'" + winename + "');";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()) {
				id_wine = rset.getInt("IDWine");
				name_wine = rset.getString("Name");
				year_wine = rset.getInt("Year");
				price_wine = rset.getFloat("Price");
				quantity_wine = rset.getInt("Quantity");
				
				Wine wine_tmp = new Wine(id_wine,name_wine,year_wine,price_wine,quantity_wine);
				output_list.add(wine_tmp);
			}
				
				conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return output_list;
	}
	
}
