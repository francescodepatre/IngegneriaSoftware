package Operations;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.Wine;
import java.util.ArrayList;

public class Wine_searchID {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public Wine wine_id(int wineid) {
		
		int id_wine = 0,year_wine = 0, quantity_wine = 0;
		
		String name_wine = "";
		float price_wine = 0;
		ArrayList<Wine> wine_output = new ArrayList<Wine>();
		
		
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT * " + " FROM wine " + " WHERE wine.IDWine = " + "'" + wineid + "'";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			
			while(rset.next()) {
				id_wine = rset.getInt("IDWine");
				name_wine = rset.getString("Name");
				year_wine = rset.getInt("Year");
				price_wine = rset.getFloat("Price");
				quantity_wine = rset.getInt("Quantity");
				
				Wine wine = new Wine(id_wine,name_wine,year_wine,price_wine,quantity_wine);
				wine_output.add(wine);
				
			}
			conn.close();
			
			
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wine_output.get(0);
	}
	

}
