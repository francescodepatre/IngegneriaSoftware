package Operations;

import java.sql.Connection;
import Interfaces.watchpropstatus_controller;
import Interfaces.customer_controller;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import Actors.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;

public class Watch_prop_status {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public ArrayList<proposal> prop_src(final int prop_id) {
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, status = 0, id_sel = 0; 
		double total_proposal = 0.0;
		String out = "Error";
		ArrayList<proposal> output_list = new ArrayList<proposal>();
			
		try {
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String strSelect = "select * from proposal where proposal.IDProposal = "+ prop_id + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			while(rset.next()) {
				id_proposal = rset.getInt("IDProposal");
				id_wine = rset.getInt("ID_wine");
				id_customer = rset.getInt("ID_customer");
				quantity = rset.getInt("Quantity");
				Date date_proposal = rset.getDate("Date_proposal");
				total_proposal = rset.getFloat("Total_proposal");
				Date date_compilation = rset.getDate("Date_compilation");
				status = rset.getInt("Seller_sign");
				id_sel = rset.getInt("ID_seller");
				
				if(date_proposal != null) {
					if(date_compilation != null) {
						proposal p = new proposal(id_proposal,id_wine,id_customer,quantity,date_proposal.toString(),total_proposal,date_compilation.toString(),status,id_sel);
						output_list.add(p);
					}
					else {
						proposal p = new proposal(id_proposal,id_wine,id_customer,quantity,date_proposal.toString(),total_proposal,null,status,id_sel);
						output_list.add(p);
					}
				}
				else {
					if(date_compilation != null) {
						proposal p = new proposal(id_proposal,id_wine,id_customer,quantity,null,total_proposal,date_compilation.toString(),status,id_sel);
						output_list.add(p);
					}
					else {
						proposal p = new proposal(id_proposal,id_wine,id_customer,quantity,null,total_proposal,null,status,id_sel);
						output_list.add(p);
					}
				}
				
			}
			
			
			
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return output_list;
	}
}
