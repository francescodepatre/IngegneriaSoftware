package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Random;
import Actors.Customer;
import Actors.Wine;

public class Compile_proposal {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void prop(final Wine wine, final int quantity, final Customer cus) {
		double total_price;
		Random rnd = new Random();
		Date date = new Date(System.currentTimeMillis());
		
		
		try {
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			total_price = wine.get_price() * quantity;
			int id_p = rnd.nextInt(00000000, 10000000);
			
			int id_oper = new Random_seller().rand_sel();
			
			String insertSql = "insert into purchase(" + id_p + "," + wine.getwine_id() + "," + total_price + ",'" + date + "'," + cus.get_id() + "," + null + ");";
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(insertSql);
			
			new Remove_quantity().rmv(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}

}
