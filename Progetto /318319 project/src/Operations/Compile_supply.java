package Operations;

import java.util.Random;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import Actors.*;

public class Compile_supply {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void compile_supply(final int idwine, final int suppid, final int quantity ) {
		Wine wine = new Wine_searchID().wine_id(idwine);
		double total_price;
		Date dat = new Date(System.currentTimeMillis());
		
		try {

			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			total_price = wine.get_price() * quantity;
			
			Random rnd = new Random();
			
			int sup_id = rnd.nextInt(10000000, 99999999);
			
			String insertSql = "insert into supply VALUES(" + sup_id + "," + idwine + "," + suppid + "," + quantity + "," + total_price + ",'" + dat + "');";
			
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(insertSql);
			
			new Add_quantity().add(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	}