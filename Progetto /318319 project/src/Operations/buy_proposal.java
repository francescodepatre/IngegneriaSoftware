package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import Actors.Customer;
import Actors.Wine;

public class buy_proposal {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void prop(final Wine wine, final int quantity, final Customer cus, final int id_p) {
		double total_price;
		Random rnd = new Random();
		Date date = new Date(System.currentTimeMillis());
		
		
		try {
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			total_price = wine.get_price() * quantity;
			
			int id_oper = new Random_seller().rand_sel();
			
			String insertSql = "insert into proposal values(" + id_p + "," + wine.getwine_id() + "," + cus.get_id() + "," + quantity + ",'" + date + "'," + total_price + ",null,null,null);";
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(insertSql);
			
			new Remove_quantity().rmv(wine, quantity);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	
	public int get_sellerid(final int seller_id) {
		int sellid = 0;
		
		
		try {
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			String insertSql = "select proposal.IDProposal from proposal where proposal.ID_seller = "+seller_id+";";
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(insertSql);
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		return sellid;
		}
	}

