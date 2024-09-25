package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Actors.Wine;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Wine_searchyear {
	
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<Wine> wine_year(final int wineyear) {
		
		int id_wine,year_wine,quantity_wine;
		String name_wine;
		float price_wine;
		ArrayList<Wine> output_list = new ArrayList<Wine>();
		
		try {
			
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "SELECT * " + " FROM wine " + " WHERE wine.Year = " + wineyear ;
			
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
