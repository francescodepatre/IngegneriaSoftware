package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Actors.Wine;
import java.util.ArrayList;

public class Wine_generalsearch {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public Wine wine_general(final String winename,final int wineyear) {
		
		int id_wine,year_wine,quantity_wine;
		String name_wine;
		float price_wine;
		ArrayList<Wine> wine_output = new ArrayList<Wine>();
		Wine output = new Wine(0,"",0,0,0);
		
		
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
				
			String strSelect = "SELECT * " + " FROM wine " + " WHERE wine.Name = " + "'" + winename + "'" + " AND wine.Year = " + wineyear;
			
			ResultSet rset = stmt.executeQuery(strSelect);
				
			
				
			while(rset.next()) {
				id_wine = rset.getInt("IDWine");
				name_wine = rset.getString("Name");
				year_wine = rset.getInt("Year");
				price_wine = rset.getFloat("Price");
				quantity_wine = rset.getInt("Quantity");
				
				output =  new Wine(id_wine,name_wine,year_wine,price_wine,quantity_wine);
				wine_output.add(output);
			}
				
			for(int i = 0; i < wine_output.size(); i++) {
				System.out.println(" ");
				System.out.println("ID: "+ wine_output.get(i).get_id());
				System.out.println("Name: "+ wine_output.get(i).get_name());
				System.out.println("Year: "+ wine_output.get(i).get_year());
				System.out.println("Price: "+ wine_output.get(i).get_price());
				if(wine_output.get(i).get_quantity() != 0) {
					System.out.println("Remaining: "+wine_output.get(i).get_quantity());
				}
				else {
					System.out.println("Wine not avaible.");
				}
				System.out.println(" ");
				
				
			}
			
			conn.close();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	

}
