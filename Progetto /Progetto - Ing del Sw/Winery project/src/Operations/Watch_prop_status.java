package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import Actors.*;

public class Watch_prop_status {
	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void prop_src(final int prop_id) {
		int id_proposal = 0, id_wine = 0, quantity = 0, id_customer = 0, status = 0, id_sel = 0; 
		double total_proposal = 0.0;
		Date date_proposal = Date.valueOf("1-1-1970");
		Date date_compilation = Date.valueOf("1-1-1970");
			
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
				
			
			String strSelect = "select * from proposal where proposal.IDProposal = "+ prop_id + ";";
			
			ResultSet rset = stmt.executeQuery(strSelect);
			
			if(rset == null) {
				System.out.println("No proposal");
				conn.close();
			}
		
			id_proposal = rset.getInt("IDOrder");
			id_wine = rset.getInt("ID_wine");
			id_customer = rset.getInt("ID_customer");
			quantity = rset.getInt("Quantity");
			date_proposal = rset.getDate("Dade_proposal");
			total_proposal = rset.getFloat("Total_proposal");
			date_compilation = rset.getDate("Date_compilation");
			status = rset.getInt("Seller_sign");
			id_sel = rset.getInt("ID_seller");

			Customer c2 = new Customer_constructor().cutsm_con(id_customer);
			Wine w2 = new Wine_searchID().wine_id(id_wine);
			
			Scanner s = new Scanner(System.in);
			
			if(status == 0) {
				System.out.println("Proposta in fase di revisione.");
			}
			else if(status != 0) {
				System.out.println("Proposta accettata");
				System.out.println("Accettare? (1/0):");
				int ch = s.nextInt();
				if(ch == 1) {
					System.out.println("Metodo di pagamento? \n 1. Carta di Credito \n 2. Bonifico\n");
					int ch2 = s.nextInt();
					switch(ch2){
						case 1:
							//compila acquisto con cred
							new Buy_wine().buy(w2, quantity, c2, "Carta di Credito");
							break;
						case 2: 
							//compila acquisto con bon
							new Buy_wine().buy(w2, quantity, c2, "Bonifico");
							break;
					
					}
				}
				else {
					new Remove_proposal().remove(id_proposal);
					System.out.println("Proposta rifiutata.");
				}
			}
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
